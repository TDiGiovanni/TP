using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Library.Classes
{
    public class Comment
    {
        public Subscriber author;   // Author of the comment
        public string text;         // Actual comment

        // Constructors
        public Comment()
        {
            this.author = new Subscriber();
            this.text = "";
        }

        public Comment(Subscriber author, string text)
        {
            this.author = author;
            this.text = text;
        }
    }
}