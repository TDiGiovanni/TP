namespace Library.Models
{
    public class SubscriberItem
    {
        private static int numberCount = 0; // Count of subscriber number

        public int number;         // Subscriber number
        public string name;        // Name
        public string password;    // Password

        // Constructors
        public SubscriberItem()
        {
            numberCount++;

            this.number = numberCount;
            this.name = "Unkown";
            this.password = "";
        }

        public SubscriberItem(string name, string password)
        {
            numberCount++;

            this.number = numberCount;
            this.name = name;
            this.password = password;
        }
    }
}
