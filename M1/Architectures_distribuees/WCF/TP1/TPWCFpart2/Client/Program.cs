using System;
using System.Collections.Generic;
using System.ServiceModel;
using share;

namespace Client
{
    class Program
    {
        static void Main(string[] args)
        {
            IService serviceProxy = new ChannelFactory<IService>("ServiceConfiguration").CreateChannel();

            Ingredient i1 = new Ingredient
            {
                Name = "i1"
            };

            Ingredient i2 = new Ingredient
            {
                Name = "i2"
            };

            Recipe r1 = new Recipe
            {
                Title = "r1",

                Ingredients = new List<Ingredient>
                {
                    i1,
                    i2
                }
            };

            serviceProxy.GetCurrentRecipes();

            Console.ReadLine();
            
        }
    }
}
