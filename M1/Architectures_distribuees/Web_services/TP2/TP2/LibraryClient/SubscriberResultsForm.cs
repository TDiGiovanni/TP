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

            nameListBox.DataSource = results;
        }
    }
}
