using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Library.Models
{
    public class BookItem
    {
        private static int COMMENT_NUMBER = 100; // Maximum number of comments

        public string title;        // Title
        public string author;       // Author
        public int isbn;            // ISBN
        public int numberOfCopies;  // Number of copies of the book
        public string editor;       // Editor
        public CommentItem[] comments;  // Array of all the comments on the book
        private int commentIndex;   // Current index where the next comment should be written

        // Constructors
        public BookItem()
        {
            this.title = "Unkown";
            this.author = "Unkown";
            this.isbn = 0;
            this.numberOfCopies = 0;
            this.editor = "Unkown";
            this.comments = new CommentItem[COMMENT_NUMBER];
            this.commentIndex = 0;
        }

        public BookItem(string title, string author, int isbn, int numberOfCopies, string editor)
        {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.numberOfCopies = numberOfCopies;
            this.editor = editor;
            this.comments = new CommentItem[COMMENT_NUMBER];
            this.commentIndex = 0;
        }

        // Add a comment on the book
        public bool AddComment(SubscriberItem subscriber, string text)
        {
            if (text != null)
            {
                this.comments[commentIndex] = new CommentItem(subscriber, text);

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
