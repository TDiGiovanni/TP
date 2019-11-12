using System;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.IO;
using System.Net;
using TP1_Shared;
using Xamarin.Forms;

namespace TP2_Forms
{
    [DesignTimeVisible(false)]
    public partial class MainPage : ContentPage
    {
        private ObservableCollection<TamSchedule> trams;
        public ObservableCollection<TamSchedule>  Trams
        {
            get => trams;
        }

        public MainPage()
        {
            InitializeComponent();
            trams = new ObservableCollection<TamSchedule>();
            TramsView.ItemsSource = trams;
            this.GetData();
        }

        private void GetData()
        {
            string uri = "http://data.montpellier3m.fr/sites/default/files/ressources/TAM_MMM_TpsReel.csv";

            HttpWebRequest request = WebRequest.CreateHttp(uri);
            request.BeginGetResponse((arg) =>
            {
                // Deserialize the CSV file
                Stream stream = request.EndGetResponse(arg).GetResponseStream();

                //
                CSVManager csvManager = new CSVManager();
                TamScheduleManager scheduleManager = new TamScheduleManager();

                foreach (TamSchedule schedule in csvManager.DownloadCSVFile(stream))
                {
                    trams.Add(schedule);
                    Console.WriteLine(schedule.TramStop);
                }

            }, null);
        }

        private void RefreshData(object sender, EventArgs e)
        {
            this.GetData();
        }
    }
}
