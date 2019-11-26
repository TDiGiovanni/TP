#pragma warning disable CS0436 // Le type est en conflit avec le type importé

using System;
using System.Collections;
using System.Collections.Generic;

#if ___ANDROID___
using Android.Content.Res;
using Android.Util;
#endif

namespace TP1_Shared
{
    public class TamSchedule
    {
        public string TramStop { get; set; }
        public List<DestinationToTime> NextTrams { get; set; }
        public string NextStop { get { return NextTrams[0].ToString(); } }

        public TamSchedule()
        {
            TramStop = "";
            NextTrams = new List<DestinationToTime>();
        }

        public override String ToString()
        {
            string s = "";

            s += "--------------------------\n";
            s += "ARR : " + TramStop + "\n";
            for (int i = 0; i < 3; i++)
            {
                s += NextTrams[i].ToString() + "\n";
            }
            s += "-------------------------- \n\n";

            return s;
        }
    }

    public class DestinationToTime
    {
        public String TramDestination { get; set; }
        public String Time { get; set; }

        public DestinationToTime(String destination, String time)
        {
            TramDestination = destination;
            Time = time;
        }

        public override string ToString()
        {
            return TramDestination + "        " + Time;
        }
    }

    public class TamScheduleManager
    {
        private TamCSVRealTime[] _tamCSVTpsReels;
        public ArrayList schedules;

#if ___ANDROID___
        private AssetManager assets;
        public TamScheduleManager(AssetManager assets)
        {
            this.assets = assets;
        }
#endif

        public TamScheduleManager(TamCSVRealTime[] table)
        {
            _tamCSVTpsReels = table;
        }

        public TamScheduleManager()
        {

        }
            
        public ArrayList CreateShedules(ArrayList table)
        {
            schedules = new ArrayList();

            for(int i = 0; i< table.Count; i+=3)
            {
                TamSchedule tamSchedule = new TamSchedule();
                TamCSVRealTime t1 = (TamCSVRealTime)table[i];
                TamCSVRealTime t2 = (TamCSVRealTime)table[i+1];
                TamCSVRealTime t3 = (TamCSVRealTime)table[i+2];

                tamSchedule.TramStop = t1.stop_name;

                tamSchedule.NextTrams.Add(new DestinationToTime(t1.trip_headsign, t1.departure_time));
                tamSchedule.NextTrams.Add(new DestinationToTime(t2.trip_headsign, t2.departure_time));
                tamSchedule.NextTrams.Add(new DestinationToTime(t3.trip_headsign, t3.departure_time));

                schedules.Add(tamSchedule);

            }

            return schedules;
        }   

        public string[] GetAllInfo()
        {
            string[] s = new string[schedules.Count];
            for (int i = 0; i < schedules.Count; i++)
            { 
               s[i] = schedules[i].ToString();
            }

            return s;
        }
    }
}
