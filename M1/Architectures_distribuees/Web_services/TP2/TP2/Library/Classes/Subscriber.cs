namespace Library
{
    public class Subscriber
    {
        private static int numberCount = 0; // Count of subscriber number

        private int number;         // Subscriber number
        private string name;        // Name
        private string password;    // Password

        // Constructors
        public Subscriber()
        {
            numberCount++;

            this.number = numberCount;
            this.name = "Unkown";
            this.password = "";
        }

        public Subscriber(string name, string password)
        {
            numberCount++;

            this.number = numberCount;
            this.name = name;
            this.password = password;
        }

        // Read accessor to 'number'
        public int GetNumber()
        {
            return this.number;
        }

        // Read accessor to 'name'
        public string GetName()
        {
            return this.name;
        }

        // Read accessor to 'password'
        public string GetPassword()
        {
            return this.password;
        }
    }
}