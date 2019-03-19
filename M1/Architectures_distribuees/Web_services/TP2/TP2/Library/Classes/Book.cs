using Library.Classes;
using System.Collections.Generic;

namespace Library
{
    public class Book
    {
        private static int COMMENT_NUMBER = 100; // Maximum number of comments

        public string title;        // Title
        public string author;       // Author
        public int isbn;            // ISBN
        public int numberOfCopies;  // Number of copies of the book
        public string editor;       // Editor
        public Comment[] comments;  // Array of all the comments on the book
        private int commentIndex;   // Current index where the next comment should be written

        // Constructors
        public Book()
        {
            this.title = "Unkown";
            this.author = "Unkown";
            this.isbn = 0;
            this.numberOfCopies = 0;
            this.editor = "Unkown";
            this.comments = new Comment[COMMENT_NUMBER];
            this.commentIndex = 0;
        }

        public Book(string title, string author, int isbn, int numberOfCopies, string editor)
        {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.numberOfCopies = numberOfCopies;
            this.editor = editor;
            this.comments = new Comment[COMMENT_NUMBER];
            this.commentIndex = 0;
        }

        // Add a comment on the book
        public bool AddComment(Subscriber subscriber, string text)
        {
            if (text != null)
            {
                this.comments[commentIndex] = new Comment(subscriber, text);

                commentIndex++;
                if (this.commentIndex == COMMENT_NUMBER)
                    commentIndex = 0;

                return true;
            }
            else
                return false;
        }
    }
}