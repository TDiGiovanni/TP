using LibraryClient.LibraryWebService;
using System.Collections.Generic;
using System.Windows.Forms;

namespace LibraryClient
{
    public partial class SubscriberResultsForm : Form
    {
        public SubscriberResultsForm()
        {
            InitializeComponent();
        }


        public SubscriberResultsForm(List<Subscriber> results)
        {
            InitializeComponent();
            
            resultsListView.Columns.Add("Name");
            resultsListView.Columns.Add("Password");
        }
    }
}
