using System;
using System.ServiceModel;
using BiblioWCF;

namespace ClientWCF
{
    class Program
    {
        static void Main(string[] args)
        {
            IService1 serviceProxy = new ChannelFactory<IService1>("ServiceConfiguration").CreateChannel();
            Console.WriteLine(serviceProxy.GetData(1));
            Console.Read();
        }
    }
}
