using System.Collections.Generic;

namespace Library
{
    public class Book
    {
        private string title;                               // Title
        private string author;                              // Author
        private int isbn;                                   // ISBN
        private int numberOfCopies;                         // Number of copies of the book
        private string editor;                              // Editor
        private Dictionary<Subscriber, string> comments;    // Key: author of comment, value: comment

        // Constructors
        public Book()
        {
            this.title = "Unkown";
            this.author = "Unkown";
            this.isbn = 0;
            this.numberOfCopies = 0;
            this.editor = "Unkown";
            this.comments = new Dictionary<Subscriber, string>();
        }

        public Book(string title, string author, int isbn, int numberOfCopies, string editor)
        {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.numberOfCopies = numberOfCopies;
            this.editor = editor;
            this.comments = new Dictionary<Subscriber, string>();
        }

        // Read accessor of 'author'
        public string GetAuthor()
        {
            return this.author;
        }

        // Read accessor of 'isbn'
        public int GetIsbn()
        {
            return this.isbn;
        }

        // Add a comment on the book
        public bool AddComment(Subscriber subscriber, string comment)
        {
            if (comment != null)
            {
                this.comments.Add(subscriber, comment);
                return true;
            }
            else
                return false;
        }
    }
}