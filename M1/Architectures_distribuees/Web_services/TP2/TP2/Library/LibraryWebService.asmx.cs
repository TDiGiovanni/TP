using Library.Classes;
using System.Collections.Generic;
using System.Web.Services;

namespace Library
{
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Pour autoriser l'appel de ce service Web depuis un script à l'aide d'ASP.NET AJAX :
    //[System.Web.Script.Services.ScriptService]
    public class LibraryWebService : System.Web.Services.WebService
    {
        private List<Book> books = new List<Book>();                    // List of books in the library
        private List<Subscriber> subscribers = new List<Subscriber>();  // List of subscribers
        private List<Librarian> librarians = new List<Librarian>();     // List of librarians
                         
        // Add a book to the list
        [WebMethod]
        public bool AddBook(int librarianNumber, string librarianPassword, string title, string author, int isbn, int numberOfCopies, string editor)
        {
            Librarian librarian = GetLibrarian(librarianNumber, librarianPassword);
            if (librarian != null)
            {
                books.Add(new Book(title, author, isbn, numberOfCopies, editor));
                return true;
            }
            else
                return false;
        }

        // Add a subscriber to the list, return its number
        [WebMethod]
        public int AddSubscriber(string password)
        {
            Subscriber subscriber = new Subscriber(password);
            subscribers.Add(subscriber);
            return subscriber.GetNumber();
        }

        // Add a librarian to the list, return its number
        [WebMethod]
        public int AddLibrarian(string password)
        {
            Librarian librarian = new Librarian(password);
            librarians.Add(librarian);
            return librarian.GetNumber();
        }

        // Get the subscriber if it exists
        [WebMethod]
        public Subscriber GetSubscriber(int number, string password)
        {
            foreach (Subscriber subscriber in subscribers)
                if (subscriber.GetNumber() == number && subscriber.GetPassword() == password)
                    return subscriber;

            return null;
        }

        // Get the librarian if it exists
        [WebMethod]
        public Librarian GetLibrarian(int number, string password)
        {
            foreach (Librarian librarian in librarians)
                if (librarian.GetNumber() == number && librarian.GetPassword() == password)
                    return librarian;

            return null;
        }

        // Return a book by its isbn, null if no book is found
        [WebMethod]
        public Book GetBookByIsbn(int isbn)
        {
            foreach (Book book in books)
                if (book.GetIsbn() == isbn)
                    return book;

            return null;
        }
        
        // Return the list of books of 'author'
        [WebMethod]
        public List<Book> GetBooksByAuthor(string author)
        {
            List<Book> books = new List<Book>();

            foreach (Book book in books)
                if (book.GetAuthor() == author)
                    books.Add(book);

            return books;
        }
        
        // Leave a comment on a book
        [WebMethod]
        public bool LeaveComment(int subscriberNumber, string subscriberPassword, int isbn, string comment)
        {
            Subscriber subscriber = GetSubscriber(subscriberNumber, subscriberPassword);
            if (subscriber != null)
                return GetBookByIsbn(isbn).AddComment(subscriber, comment);

            return false;
        }
    }
}

