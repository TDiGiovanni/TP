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
            //string uri = "http://data.montpellier3m.fr/sites/default/files/ressources/TAM_MMM_TpsReel.csv";
            string uri = "https://gite.lirmm.fr/hlad/hmin309-tp1-xamarin/raw/master/smallHoraire.csv";

            HttpWebRequest request = WebRequest.CreateHttp(uri);
            request.BeginGetResponse((arg) =>
            {
                // Deserialize the CSV file
                Stream stream = request.EndGetResponse(arg).GetResponseStream();

                // Convert the CSv to our objects
                CSVManager csvManager = new CSVManager();
                TamScheduleManager scheduleManager = new TamScheduleManager();
                scheduleManager.CreateShedules(csvManager.DownloadCSVFile(stream));

                // Populate the list
                foreach (TamSchedule schedule in scheduleManager.schedules)
                {
                    trams.Add(schedule);
                }

            }, null);
        }

        private void RefreshData(object sender, EventArgs e)
        {
            InformationLayout.IsVisible = false;

            EmptyTramList();

            this.GetData();
        }

        private void EmptyTramList()
        {
            for (int i = 0; i < trams.Count; i++)
            {
                trams.RemoveAt(i);
            }
        }

        private void OnItemTapped(object sender, SelectedItemChangedEventArgs e)
        {
            InformationLayout.IsVisible = true;

            //var tam = (TamSchedule)TramsView.SelectedItem;
            var tam = (TamSchedule)e.SelectedItem;

            stopName.Text = tam.TramStop;
            firstTram.Text = tam.NextTrams[0].ToString();
            secondTram.Text = tam.NextTrams[1].ToString();
            thirdTram.Text = tam.NextTrams[2].ToString();
        }

        // InformationLayout close button action
        private void CloseInformationLayout(object sender, EventArgs e)
        {
            InformationLayout.IsVisible = false;
        }
    }
}
