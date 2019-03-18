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

            nameListBox.DataSource = results;
        }
    }
}
