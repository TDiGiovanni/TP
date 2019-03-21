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

            MessageBox.Show("Book added!");
        }

        private void GetAllBooksButton_Click(object sender, EventArgs e)
        {
            List<LibraryWebService.Book> result = new List<LibraryWebService.Book>(library.GetAllBooks());

            ShowResults(result);
        }

        // Replace with GetBookByAuthorButton
        private void GetBookByTitleButton_Click(object sender, EventArgs e)
        {
            List<LibraryWebService.Book> result = new List<LibraryWebService.Book>(library.GetBooksByAuthor(bookAuthorTextBox.Text));

            ShowResults(result);
        }

        private void GetBookByIsbnButton_Click(object sender, EventArgs e)
        {
            List<LibraryWebService.Book> result = new List<LibraryWebService.Book>
            {
                library.GetBookByIsbn(int.Parse(bookIsbnTextBox.Text))
            };

            ShowResults(result);
        }

        private void GetAllCommentsButton_Click(object sender, EventArgs e)
        {
            List<LibraryWebService.Comment> result = new List<LibraryWebService.Comment>();

            foreach (LibraryWebService.Comment comment in library.GetBookByIsbn(int.Parse(bookIsbnTextBox.Text)).comments)
            {
                result.Add(comment);
            }

            ShowResults(result);
        }

        private void AddSubscriberButton_Click(object sender, EventArgs e)
        {
            int subscriberNumber = library.AddSubscriber(subscriberNameTextBox.Text,
                subscriberPasswordTextBox.Text);

            MessageBox.Show("Subscriber (number " + subscriberNumber + ") added!");
        }

        private void GetAllSubscribersButton_Click(object sender, EventArgs e)
        {
            List<LibraryWebService.Subscriber> result = new List<LibraryWebService.Subscriber>(library.GetAllSubscribers());

            ShowResults(result);
        }

        private void GetSubscriberByNameButton_Click(object sender, EventArgs e)
        {
            List<LibraryWebService.Subscriber> result = new List<LibraryWebService.Subscriber>(library.GetSubscribersByName(subscriberNameTextBox.Text));

            ShowResults(result);
        }

        private void LeaveCommentButton_Click(object sender, EventArgs e)
        {
            bool commentLeft = library.LeaveComment(int.Parse(subscriberNumberTextBox.Text),
                subscriberPasswordTextBox.Text,
                int.Parse(bookIsbnTextBox.Text),
                subscriberCommentTextBox.Text);

            if (commentLeft)
                MessageBox.Show("Comment added!");
            else
                MessageBox.Show("Error while adding the comment");
        }

        private void ShowResults(List<LibraryWebService.Book> bookList)
        {
            BookResultsForm results = new BookResultsForm();
            results.Show();
        }

        private void ShowResults(List<LibraryWebService.Comment> commentList)
        {
            CommentResultsForm results = new CommentResultsForm();
            results.Show();
        }

        private void ShowResults(List<LibraryWebService.Subscriber> subscriberList)
        {
            SubscriberResultsForm results = new SubscriberResultsForm();
            results.Show();
        }
    }
}
