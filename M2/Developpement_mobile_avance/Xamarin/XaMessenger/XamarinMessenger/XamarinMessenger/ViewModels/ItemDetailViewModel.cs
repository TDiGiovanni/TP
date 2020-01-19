using System;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Threading.Tasks;
using Xamarin.Forms;
using XamarinMessenger.Models;

namespace XamarinMessenger.ViewModels
{
    public class ItemDetailViewModel : BaseViewModel
    {
        public Item SelectedItem { get; set; }
        public ObservableCollection<Item> AuthorItems { get; set; }
        public Command LoadItemsCommand { get; set; }

        public ItemDetailViewModel(Item selectedItem = null)
        {
            Title = selectedItem?.student_message;
            SelectedItem = selectedItem;
            AuthorItems = new ObservableCollection<Item>();

            LoadItemsCommand = new Command(async () => await ExecuteLoadItemsCommand());
        }

        async Task ExecuteLoadItemsCommand()
        {
            if (IsBusy)
                return;

            IsBusy = true;

            try
            {
                AuthorItems.Clear();
                var items = await DataStore.GetItemsAsync(true);
                foreach (var item in items)
                {
                    if (item.student_id == this.SelectedItem.student_id)
                        AuthorItems.Add(item);
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
