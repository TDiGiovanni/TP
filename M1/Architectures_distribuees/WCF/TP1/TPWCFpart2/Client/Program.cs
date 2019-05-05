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

            // Creating ingredients
            Ingredient i1 = new Ingredient
            {
                Name = "i1"
            };

            Ingredient i2 = new Ingredient
            {
                Name = "i2"
            };

            Ingredient i3 = new Ingredient
            {
                Name = "i3"
            };

            // Creating recipes
            Recipe r1 = new Recipe
            {
                Title = "r1",

                Ingredients = new List<Ingredient>
                {
                    i1,
                    i2
                }
            };

            Recipe r2 = new Recipe
            {
                Title = "r2",

                Ingredients = new List<Ingredient>
                {
                    i1,
                    i3
                }
            };

            // Adding recipes
            serviceProxy.AddRecipe(r1);
            serviceProxy.AddRecipe(r2);

            // Testing
            Console.WriteLine(serviceProxy.GetRecipesByIngredient(i1.Name).ToString()); // Output should be: r1, r2
            serviceProxy.DeleteFromCurrentRecipes(r2);
            Console.WriteLine(serviceProxy.GetCurrentRecipes()); // Output should be: r1
            Console.WriteLine(serviceProxy.GetRecipesByIngredient(i3.Name).ToString()); // Output should be: r2

            // End
            Console.WriteLine("Enter anything to leave");
            Console.ReadLine();
        }
    }
}
