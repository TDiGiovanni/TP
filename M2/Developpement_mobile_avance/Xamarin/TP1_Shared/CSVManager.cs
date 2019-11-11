using System;
using System.Collections.Generic;
using System.Text;

namespace TP1_Shared
{
    public class CSVManager
    {
        public void ReadCSV(AssetManager assets)
        {
            string fileName = "HorairesTram.csv";

            ArrayList a = new ArrayList();
            
#if __ANDROID__
            AssetManager assets = Assets;
            using (StreamReader reader = new StreamReader(assets.Open(Filename)))
#elif __IOS__
            using (var reader = new StreamReader(Filename))
#endif

            using (var csv = new CsvReader(reader))
            {
                var records = csv.GetRecords<TamCSVTpsReel>();
                IEnumerator enumerator = records.GetEnumerator();

                while (enumerator.MoveNext())
                {
                    object item = enumerator.Current;
                    TamCSVTpsReel t = (TamCSVTpsReel)item;
                    a.Add(t);
#if __ANDROID__
                    Log.Debug("TYPE_MESSAGE", "Message content");
                    Log.Debug("DEBUG", t.stop_code);
#endif 
                }
            }
            return a;
        }
    }
}
