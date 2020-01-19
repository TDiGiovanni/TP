using SQLite;
using Xamarin.Forms.Maps;
using System.ComponentModel;

namespace XamarinMessenger.Models
{
    [Table("item")]
    public class Item : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        [PrimaryKey]
        public int id { get; set; }

        public int student_id { get; set; }

        public double gps_lat { get; set; }

        public double gps_long { get; set; }

        public string student_message { get; set; }

        // Used to show a star next to the favorite messages
        private bool isFavorite;
        [Ignore]
        public bool IsFavorite
        {
            get { return isFavorite; }
            set
            {
                isFavorite = value;
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(nameof(IsFavorite)));
            }
        }
        
        // Used to bind a color to the author
        private Author student;
        [Ignore]
        public Author Student
        {
            get { return student; }
            set
            {
                student = value;
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(nameof(Student)));
            }
        }

        [Ignore] /* Property used to display a PIN on Map, shall not be stored in DB*/
        public Position student_position { get; set; }

        public void SetStudentPosition() {
            student_position = new Position(gps_lat, gps_long);
        }

        public Position GetStudentPosition()
        {
            return new Position(gps_lat, gps_long);
        }
    }
}