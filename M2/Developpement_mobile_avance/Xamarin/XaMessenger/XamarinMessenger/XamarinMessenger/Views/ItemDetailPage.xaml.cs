using SQLite;
using System;
using System.ComponentModel;
using System.IO;
using Xamarin.Forms;

using XamarinMessenger.Models;
using XamarinMessenger.ViewModels;

namespace XamarinMessenger.Views
{
    [DesignTimeVisible(false)]
    public partial class ItemDetailPage : ContentPage
    {
        private readonly ItemDetailViewModel viewModel;

        public ItemDetailPage(ItemDetailViewModel viewModel)
        {
            InitializeComponent();

            BindingContext = this.viewModel = viewModel;
        }

        public ItemDetailPage()
        {
            InitializeComponent();

            var item = new Item
            {
                student_message = "Message",
                student_id = 1,
                gps_lat = 0,
                gps_long = 0
            };

            BindingContext = this.viewModel = new ItemDetailViewModel(item);
        }

        protected override void OnAppearing()
        {
            base.OnAppearing();

            if (viewModel.AuthorItems.Count == 0)
                viewModel.LoadItemsCommand.Execute(null);
        }

        // Add to favorites button
        public void OnButtonClicked(object sender, EventArgs args)
        {
            string filePath = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.Personal), "Favorites.db");
            SQLiteConnection connection = new SQLiteConnection(filePath);
            connection.CreateTable<Item>();

            var existingItem = from item in connection.Table<Item>()
                                where item.id.Equals(viewModel.SelectedItem.id)
                                select item;

            if (existingItem.Count() == 0)
                connection.Insert(viewModel.SelectedItem);
        }

        // Picker event
        public void OnPickerClicked(object sender, EventArgs args)
        {
            Picker picker = sender as Picker;

            string filePath = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.Personal), "Favorites.db");
            SQLiteConnection connection = new SQLiteConnection(filePath);
            connection.CreateTable<Author>();

            // Delete the previous value if it exists
            connection.Table<Author>().Delete(i => i.Id == viewModel.SelectedItem.student_id);

            // Save the new one
            connection.Insert(new Author { Id = viewModel.SelectedItem.student_id, Color = picker.SelectedItem.ToString() });
        }
    }
}
