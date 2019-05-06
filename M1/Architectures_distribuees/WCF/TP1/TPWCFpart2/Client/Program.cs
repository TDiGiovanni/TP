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
            List<Recipe> result = serviceProxy.GetRecipesByIngredient(i1.Name);
            Console.WriteLine("Recipes with i1:");
            for (int i = 0; i < result.Count; i++)
                Console.WriteLine(result[i].Title); // Output should be: r1, r2

            Console.WriteLine("\nDeleting i2 from the list...");
            serviceProxy.DeleteFromCurrentRecipes(r2);
            result = serviceProxy.GetCurrentRecipes();
            for (int i = 0; i < result.Count; i++)
                Console.WriteLine(result[i].Title); // Output should be: r1
            
            result = serviceProxy.GetRecipesByIngredient(i3.Name);
            Console.WriteLine("\nRecipes with i3:");
            for (int i = 0; i < result.Count; i++)
                Console.WriteLine(result[i].Title); // Output should be: r2

            // End
            Console.WriteLine("Enter anything to leave");
            Console.ReadLine();
        }
    }
}
