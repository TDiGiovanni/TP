using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace LibraryClient
{
    public partial class LibraryManagerForm : Form
    {
        private LibraryWebService.LibraryWebService library = new LibraryWebService.LibraryWebService();

        public LibraryManagerForm()
        {
            InitializeComponent();
        }

        private void AddBookButton_Click(object sender, EventArgs e)
        {
            library.AddBook(bookTitleTextBox.Text,
                bookAuthorTextBox.Text,
                int.Parse(bookIsbnTextBox.Text),
                int.Parse(bookNumberOfCopiesTextBox.Text),
                bookEditorTextBox.Text);
        }

        private void GetAllBooksButton_Click(object sender, EventArgs e)
        {
            List<LibraryWebService.Book> result = new List<LibraryWebService.Book>(library.GetAllBooks());

            ShowBookResults(result);
        }

        // Replace with GetBookByAuthorButton
        private void GetBookByTitleButton_Click(object sender, EventArgs e)
        {
            List<LibraryWebService.Book> result = new List<LibraryWebService.Book>(library.GetBooksByAuthor(bookAuthorTextBox.Text));

            ShowBookResults(result);
        }

        private void GetBookByIsbnButton_Click(object sender, EventArgs e)
        {
            List<LibraryWebService.Book> result = new List<LibraryWebService.Book>
            {
                library.GetBookByIsbn(int.Parse(bookIsbnTextBox.Text))
            };

            ShowBookResults(result);
        }

        private void AddSubscriberButton_Click(object sender, EventArgs e)
        {
            library.AddSubscriber(subscriberNameTextBox.Text,
                subscriberPasswordTextBox.Text);
        }

        private void GetAllSubscribersButton_Click(object sender, EventArgs e)
        {
            List<LibraryWebService.Subscriber> result = new List<LibraryWebService.Subscriber>(library.GetAllSubscribers());

            ShowSubscriberResults(result);
        }

        private void GetSubscriberByNameButton_Click(object sender, EventArgs e)
        {
            List<LibraryWebService.Subscriber> result = new List<LibraryWebService.Subscriber>(library.GetSubscribersByName(subscriberNameTextBox.Text));

            ShowSubscriberResults(result);
        }

        private void ShowBookResults(List<LibraryWebService.Book> bookList)
        {
            BookResultsForm results = new BookResultsForm();
            results.Show();
        }

        private void ShowSubscriberResults(List<LibraryWebService.Subscriber> subscriberList)
        {
            SubscriberResultsForm results = new SubscriberResultsForm();
            results.Show();
        }
    }
}
