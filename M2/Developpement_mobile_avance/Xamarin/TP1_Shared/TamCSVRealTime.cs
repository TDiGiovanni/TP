using System;
using System.Collections.Generic;
using System.Text;

namespace TP1_Shared
{
    public class TamCSVRealTime
    {
        int course              { get; set; }
        string stop_code        { get; set; }
        int stop_id             { get; set; }
        string stop_name        { get; set; }
        int route_short_name    { get; set; }
        string trip_headsign    { get; set; }
        int direction_id        { get; set; }
        string departure_time   { get; set; }
        bool is_theorical       { get; set; }
        int delay_sec           { get; set; }
        int dest_ar_code        { get; set; }
    }
}
