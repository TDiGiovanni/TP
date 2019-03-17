namespace Library
{
    public class Subscriber
    {
        private static int numberCount = 0; // Count of subscriber number

        private int number;         // Subscriber number
        private string password;    // Password

        // Constructor
        public Subscriber(string password)
        {
            numberCount++;

            this.number = numberCount;
            this.password = password;
        }

        // Read accessor to 'number'
        public int GetNumber()
        {
            return this.number;
        }

        // Read accessor to 'password'
        public string GetPassword()
        {
            return this.password;
        }
    }
}