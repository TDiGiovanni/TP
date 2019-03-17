using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Weather.gov.weather.graphical;

namespace Weather
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Weather app");

            ndfdXML weather = new ndfdXML();
            Console.WriteLine(weather.LatLonListCityNames(""));
            //Console.WriteLine(weather.NDFDgen(0, 0, "glance", new System.DateTime(2018,12,01,12,00,00,00), new System.DateTime(2018,12,01,12,00,00,00), "m", null));

            Console.WriteLine("Press anything to quit");
            Console.ReadLine();
        }
    }
}
