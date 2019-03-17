namespace Library.Classes
{
    public class Librarian
    {
        private static int numberCount = 0; // Count of librarian number

        private int number;         // Librarian number
        private string password;    // Password

        // Constructor
        public Librarian(string password)
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
