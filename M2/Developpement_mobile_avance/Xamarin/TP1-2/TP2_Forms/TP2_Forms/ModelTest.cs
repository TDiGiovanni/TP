using System;
using System.ComponentModel;

namespace TP2_Forms
{
    public class ModelTest : INotifyPropertyChanged
    {
        private string address = String.Empty; // Equivalent of Null
        public string Address
        {
            get => address;
            set
            {
                // If the name has not changed, do nothing
                if (address == value)
                    return;

                // Otherwise we set the name to its new value and trigger the event
                // All UI elements that have subscribed (bind) to the property named Address will be updated
                address = value;
                OnPropertyChanged(nameof(Address));
            }
        }

        // Adds a special event to the class
        public event PropertyChangedEventHandler PropertyChanged;

        // Method that fired the event when changes happen
        void OnPropertyChanged(string name)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
    }
}
