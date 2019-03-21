using System.Collections.Generic;
using System.Web.Services;

namespace Library
{
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Pour autoriser l'appel de ce service Web depuis un script à l'aide d'ASP.NET AJAX :
    //[System.Web.Script.Services.ScriptService]
    public class LibraryWebService : WebService
    {
        private static List<Book> books = new List<Book>();                    // List of books in the library
        private static List<Subscriber> subscribers = new List<Subscriber>();  // List of subscribers

        // Adds a book to the list
        [WebMethod]
        public void AddBook(string title, string author, int isbn, int numberOfCopies, string editor)
        {
            Book book = new Book(title, author, isbn, numberOfCopies, editor);
            books.Add(book);
        }

        // Adds a subscriber to the list, return its number
        [WebMethod]
        public int AddSubscriber(string name, string password)
        {
            Subscriber subscriber = new Subscriber(name, password);
            subscribers.Add(subscriber);
            return subscriber.number;
        }

        // Gets the subscriber if it exists
        [WebMethod]
        public Subscriber GetSubscriber(int number, string password)
        {
            foreach (Subscriber subscriber in subscribers)
                if (subscriber.number == number && subscriber.password == password)
                    return subscriber;

            return null;
        }

        // Returns the list of all the books
        [WebMethod]
        public Book[] GetAllBooks()
        {
            return books.ToArray();
        }

        // Returns a book by its isbn, null if no book is found
        [WebMethod]
        public Book GetBookByIsbn(int isbn)
        {
            foreach (Book book in books)
                if (book.isbn == isbn)
                    return book;

            return null;
        }

        // Returns the list of books of 'author'
        [WebMethod]
        public Book[] GetBooksByAuthor(string author)
        {
            List<Book> books = new List<Book>();

            foreach (Book book in books)
                if (book.author == author)
                    books.Add(book);

            return books.ToArray();
        }

        // Returns the list of all the subscribers
        [WebMethod]
        public Subscriber[] GetAllSubscribers()
        {
            return subscribers.ToArray();
        }

        // Searches for subcribers by name
        [WebMethod]
        public Subscriber[] GetSubscribersByName(string name)
        {
            List<Subscriber> books = new List<Subscriber>();

            foreach (Subscriber subscriber in subscribers)
                if (subscriber.name == name)
                    subscribers.Add(subscriber);

            return subscribers.ToArray();
        }

        // Leaves a comment on a book
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
