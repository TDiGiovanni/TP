using LibraryClient.LibraryWebService;
using System.Collections.Generic;
using System.Windows.Forms;

namespace LibraryClient
{
    public partial class BookResultsForm : Form
    {
        public BookResultsForm()
        {
            InitializeComponent();
        }

        public BookResultsForm(List<Book> results)
        {
            InitializeComponent();

            resultsListView.Columns.Add("Name");
            resultsListView.Columns.Add("Author");
            resultsListView.Columns.Add("ISBN");
            resultsListView.Columns.Add("Number of copies");
            resultsListView.Columns.Add("Editor");

            foreach (Book result in results)
            {
                ListViewItem book = new ListViewItem(result.title);
                book.SubItems.Add(result.author);
                book.SubItems.Add(result.isbn.ToString());
                book.SubItems.Add(result.numberOfCopies.ToString());
                book.SubItems.Add(result.editor);
                resultsListView.Items.Add(book);
            }

            //resultsListView.View = View.Details;
        }
    }
}
