using ClientMexWCF.ServiceReference1;
using System;

namespace ClientMexWCF
{
    class Program
    {
        static void Main(string[] args)
        {
            Service1Client proxy = new Service1Client();
            String s = proxy.GetData(0);
            Console.WriteLine(s);

            Console.ReadLine();
        }
    }
}
