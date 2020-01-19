using System;
using System.Windows.Input;

using Xamarin.Forms;
using Xamarin.Essentials;

namespace XamarinMessenger.ViewModels
{
    public class AboutViewModel : BaseViewModel
    {
        public AboutViewModel()
        {
            Title = "A propos";

            OpenWebCommand = new Command(() => Launcher.OpenAsync(new Uri("https://github.com/DrakenXI/XaMessenger")));
        }

        public ICommand OpenWebCommand { get; }
    }
}