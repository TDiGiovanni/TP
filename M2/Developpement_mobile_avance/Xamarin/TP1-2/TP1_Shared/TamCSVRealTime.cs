using System;
using System.Collections.Generic;
using System.Text;

namespace TP1_Shared
{
    public class TamCSVRealTime
    {
        private long course { get; set; }
        public string stop_code { get; set; }
        public long stop_id { get; set; }
        public string stop_name { get; set; }
        public long route_short_name { get; set; }
        public string trip_headsign { get; set; }
        public long direction_id { get; set; }
        public string departure_time { get; set; }
        public bool is_theorical { get; set; }
        public long delay_sec { get; set; }
        public long dest_ar_code { get; set; }

        public TamCSVRealTime()
        {

        }

        public void Setup(string line)
        {
            var values = line.Split(';');

            course = long.Parse(values[0]);
            stop_code = values[1];
            stop_id = long.Parse(values[2]);
            stop_name = values[3];
            route_short_name = long.Parse(values[4]);
            trip_headsign = values[5];
            direction_id = long.Parse(values[6]);
            departure_time = values[7];

            if (int.Parse(values[8]) == 1)
            {
                is_theorical = true;
            }
            else
            {
                is_theorical = false;
            }

            delay_sec = long.Parse(values[9]);
            dest_ar_code = long.Parse(values[10]);
        }
    }
}
