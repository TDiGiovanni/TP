using SQLite;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

using Xamarin.Forms;

using XamarinMessenger.Models;
using XamarinMessenger.Views;

namespace XamarinMessenger.ViewModels
{
    public class ItemsViewModel : BaseViewModel
    {
        public ObservableCollection<Item> Items { get; set; }
        public ObservableCollection<Author> Students { get; set; }
        public Command LoadItemsCommand { get; set; }

        public ItemsViewModel()
        {
            Title = "Messages";
            Items = new ObservableCollection<Item>();
            Students = new ObservableCollection<Author>();
            LoadItemsCommand = new Command(async () => await ExecuteLoadItemsCommand());

            MessagingCenter.Subscribe<MapPage, Item>(this, "AddItem", async (obj, item) =>
            {
                var newItem = item as Item;
                Items.Add(newItem);
                await DataStore.AddItemAsync(newItem);
            });

            /* Each 30 seconds, auto fetch from server */
            Device.StartTimer(TimeSpan.FromMilliseconds(30000), loop2);
            bool loop2()
            {
                LoadItemsCommand.Execute(null);
                return true;
            }
        }

        async Task ExecuteLoadItemsCommand()
        {
            if (IsBusy)
                return;

            IsBusy = true;

            try
            {
                Items.Clear();

                // First load the assigned "colors"
                string filePath = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.Personal), "Favorites.db");
                SQLiteConnection connection = new SQLiteConnection(filePath);

                connection.CreateTable<Author>();
                List<Author> favoriteColors = connection.Table<Author>().ToList();
                foreach (Author item in favoriteColors)
                {
                    if (!Students.Any(i => i.Id == item.Id))
                        Students.Add(item);
                }

                // Load the favorite colors, and create the missing "colors"
                connection.CreateTable<Item>();
                List<Item> favoriteItems = connection.Table<Item>().ToList();
                foreach (Item item in favoriteItems)
                {
                    item.IsFavorite = true;
                    Items.Add(item);

                    Author matchingAuthor = Students.SingleOrDefault(i => i.Id == item.student_id);
                    if (matchingAuthor == null)
                    {
                        matchingAuthor = new Author { Id = item.student_id };
                        Students.Add(matchingAuthor);
                    }

                    item.Student = matchingAuthor;
                }

                // Then load the other messages from the server, and create the final "colors"
                var items = await DataStore.GetItemsAsync(true);
                foreach (Item item in items)
                {
                    if (!Items.Any(i => i.id == item.id))
                        Items.Add(item);

                    Author matchingAuthor = Students.SingleOrDefault(i => i.Id == item.student_id);
                    if (matchingAuthor == null)
                    {
                        matchingAuthor = new Author { Id = item.student_id };
                        Students.Add(matchingAuthor);
                    }

                    item.Student = matchingAuthor;
                }
            }
            catch (Exception ex)
            {
                Debug.WriteLine(ex);
            }
            finally
            {
                IsBusy = false;
            }
        }
    }
}