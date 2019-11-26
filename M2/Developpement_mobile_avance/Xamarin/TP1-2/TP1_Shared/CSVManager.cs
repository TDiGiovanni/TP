#pragma warning disable CS0436 // Le type est en conflit avec le type importé

using CsvHelper;
using System.Collections;
using System.IO;

namespace TP1_Shared
{
    public class CSVManager
    {
        public CSVManager()
        {

        }

        private ArrayList ReadData(StreamReader reader)
        {
            ArrayList a = new ArrayList();

            using (var csv = new CsvReader(reader))
            {
                csv.Configuration.Delimiter = ";";

                var records = csv.GetRecords<TamCSVRealTime>();
                IEnumerator enumerator = records.GetEnumerator();

                while (enumerator.MoveNext())
                {
                    object item = enumerator.Current;
                    TamCSVRealTime t = (TamCSVRealTime)item;
                    a.Add(t);
                }
            }

            return a;
        }

        public ArrayList DownloadCSVFile(Stream stream)
        {
            return this.ReadData(new StreamReader(stream));
        }
    }
}
