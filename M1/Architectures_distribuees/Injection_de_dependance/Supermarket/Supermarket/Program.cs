using System;
using System.Collections.Generic;
using Ninject;
using Ninject.Modules;

namespace Supermarket
{
    // Interface of all client parameters loaders
    interface IClientParametersLoader
    {
        void SetClient(ClientParameters client);

        string GetParameters();
    }

    // ClientParametersLoader
    class ClientParametersLoader : IClientParametersLoader
    {
        protected ClientParameters client;

        public ClientParametersLoader(ClientParameters client)
        {
            this.client = client;
        }

        public void SetClient(ClientParameters client)
        {
            this.client = client;
        }

        public string GetParameters()
        {
            return this.client.GetProfile();
        }
    }

    // Parameters of a client (only a string)
    class ClientParameters
    {
        protected string profile;

        public ClientParameters(string profile)
        {
            this.profile = profile;
        }

        public string GetProfile()
        {
            return this.profile;
        }
    }

    // Article
    class Article
    {
        protected string name;
        protected float price;

        public Article(string name, float price)
        {
            this.name = name;
            this.price = price;
        }

        public override string ToString()
        {
            return this.name + " : " + this.price + " euros";
        }
    }

    // Receipt
    class Receipt
    {
        protected IClientParametersLoader loader;
        protected List<Article> articles;

        public Receipt(IClientParametersLoader loader)
        {
            this.loader = loader;
            this.articles = new List<Article>();
        }

        public Receipt(IClientParametersLoader loader, List<Article> articles)
        {
            this.loader = loader;
            this.articles = articles;
        }

        public string GetClientParameters()
        {
            return loader.GetParameters();
        }

        public void AddArticle(Article article)
        {
            this.articles.Add(article);
        }

        public void Print()
        {
            Console.WriteLine("Receipt \n" +
                "Client : " + this.loader.GetParameters() + "\n" +
                "Articles list:");

            foreach (Article article in articles)
                Console.WriteLine(article.ToString());
        }
    }

    // Bindings for Ninject
    public class Bindings : NinjectModule
    {
        public override void Load()
        {
            ClientParameters client = new ClientParameters("Famille nombreuse");
            //ClientParameters client = new ClientParameters("Sélection de produits à prix réduits");

            Bind<IClientParametersLoader>().To<ClientParametersLoader>().WithConstructorArgument("client", client);
        }
    }

    // Main application
    class Program
    {
        static void Main(string[] args)
        {
            // Binding the right loader
            IKernel kernel = new StandardKernel(new Bindings());
            IClientParametersLoader loader = kernel.Get<IClientParametersLoader>();

            // Creation of articles
            Article a1 = new Article("Article 1", 5);
            Article a2 = new Article("Article 2", 10);
            Article a3 = new Article("Article 3", 15);

            // Creation of receipt
            Receipt receipt = new Receipt(loader);
            receipt.AddArticle(a1);
            receipt.AddArticle(a1);
            receipt.AddArticle(a2);
            receipt.AddArticle(a3);
            receipt.AddArticle(a3);
            receipt.Print();

            // End of application
            Console.WriteLine("\nEnter anything to leave");
            Console.ReadLine();
        }
    }
}
