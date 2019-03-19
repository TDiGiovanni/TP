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
                resultsListView.Items.Add("test");


            resultsListView.Items.Add("test").SubItems.Add("subtest");
        }
    }
}
