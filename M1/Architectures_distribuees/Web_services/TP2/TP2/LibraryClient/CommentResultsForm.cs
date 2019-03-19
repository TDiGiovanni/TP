using LibraryClient.LibraryWebService;
using System.Collections.Generic;
using System.Windows.Forms;

namespace LibraryClient
{
    public partial class CommentResultsForm : Form
    {
        public CommentResultsForm()
        {
            InitializeComponent();
        }

        public CommentResultsForm(List<Comment> results)
        {
            InitializeComponent();

            resultsListView.Columns.Add("Author");
            resultsListView.Columns.Add("Comment");

            foreach (Comment result in results)
            {
                ListViewItem comment = new ListViewItem(result.author.number.ToString());
                comment.SubItems.Add(result.text);
                resultsListView.Items.Add(comment);
            }
        }
    }
}
