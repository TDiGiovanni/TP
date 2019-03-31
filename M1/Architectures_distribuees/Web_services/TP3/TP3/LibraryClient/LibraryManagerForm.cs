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
            string input = bookAuthorTextBox.Text;
            if (IsEmpty(input))
                return;

            List<LibraryWebService.Book> result = new List<LibraryWebService.Book>(library.GetBooksByAuthor(input));

            ShowResults(result);
        }

        private void GetBookByIsbnButton_Click(object sender, EventArgs e)
        {
            string input = bookIsbnTextBox.Text;
            if (IsEmpty(input))
                return;

            List<LibraryWebService.Book> result = new List<LibraryWebService.Book>
            {
                library.GetBookByIsbn(int.Parse(bookIsbnTextBox.Text))
            };

            ShowResults(result);
        }

        private void GetAllCommentsButton_Click(object sender, EventArgs e)
        {
            string input = bookIsbnTextBox.Text;
            if (IsEmpty(input))
                return;

            List<LibraryWebService.Comment> result = new List<LibraryWebService.Comment>();

            foreach (LibraryWebService.Comment comment in library.GetBookByIsbn(int.Parse(input)).comments)
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
            string input = subscriberNameTextBox.Text;
            if (IsEmpty(input))
                return;

            List<LibraryWebService.Subscriber> result = new List<LibraryWebService.Subscriber>(library.GetSubscribersByName(input));

            ShowResults(result);
        }

        private void LeaveCommentButton_Click(object sender, EventArgs e)
        {
            if (IsEmpty(subscriberNumberTextBox.Text)
                || IsEmpty(subscriberPasswordTextBox.Text)
                || IsEmpty(bookIsbnTextBox.Text)
                || IsEmpty(subscriberCommentTextBox.Text))
                return;

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
            BookResultsForm results = new BookResultsForm(bookList);
            results.Show();
        }

        private void ShowResults(List<LibraryWebService.Comment> commentList)
        {
            CommentResultsForm results = new CommentResultsForm(commentList);
            results.Show();
        }

        private void ShowResults(List<LibraryWebService.Subscriber> subscriberList)
        {
            SubscriberResultsForm results = new SubscriberResultsForm(subscriberList);
            results.Show();
        }

        private bool IsEmpty(string text)
        {
            if (string.IsNullOrWhiteSpace(text))
            {
                MessageBox.Show("Error: missing information");
                return true;
            }
            else
                return false;
        }
    }
}
