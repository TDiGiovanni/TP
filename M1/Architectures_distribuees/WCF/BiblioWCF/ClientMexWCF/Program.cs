using System;
using ClientMexWCF.BiblioWCF;

namespace ClientMexWCF
{
    class Program
    {
        static void Main(string[] args)
        {
            Service1Client proxy = new Service1Client();
            String s = proxy.GetData(0);
            Console.WriteLine(s);
        }
    }
}
