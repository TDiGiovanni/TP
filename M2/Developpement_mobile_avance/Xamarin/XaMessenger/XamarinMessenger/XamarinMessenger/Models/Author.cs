using SQLite;
using System.ComponentModel;

namespace XamarinMessenger.Models
{
    [Table("author")]
    public class Author : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        [PrimaryKey]
        public int Id { get; set; }

        private string color = "White";
        public string Color
        {
            get
            {
                return color;
            }
            set
            {
                color = value;
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(nameof(Color)));
            }
        }
    }
}
