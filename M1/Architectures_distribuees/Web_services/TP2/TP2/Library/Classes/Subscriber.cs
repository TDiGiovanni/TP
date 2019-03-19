using System;

namespace Library
{
    public class Subscriber
    {
        private static int numberCount = 0; // Count of subscriber number

        public int number;         // Subscriber number
        public string name;        // Name
        public string password;    // Password

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
    }
}