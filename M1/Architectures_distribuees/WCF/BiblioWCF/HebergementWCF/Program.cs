using System;
using System.ServiceModel;
using BiblioWCF;

namespace HebergementWCF
{
    class Program
    {
        static void Main(string[] args)
        {
            using (ServiceHost serviceHost = new ServiceHost(typeof(Service1)))
            {
                try
                {
                    // Open the ServiceHost to s t a r t  l i s t e n i n g for messages
                    serviceHost.Open();

                    // The service can now be accessed
                    Console.WriteLine("The s e r v i c e is ready.");
                    Console.WriteLine("Press <ENTER> to terminate s e r v i c e.");
                    Console.ReadLine();

                    // Close the ServiceHost
                    serviceHost.Close();
                }
                catch (TimeoutException timeProblem)
                {
                    Console.WriteLine(timeProblem.Message);
                    Console.ReadLine();
                }
                catch (CommunicationException commProblem)
                {
                    Console.WriteLine(commProblem.Message);
                    Console.ReadLine();
                }
            }
        }
    }
}
