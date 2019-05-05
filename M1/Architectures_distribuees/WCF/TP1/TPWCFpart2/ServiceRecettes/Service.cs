using share;
using System.Collections.Generic;

namespace ServiceRecettes
{
    public class Service : IService
    {
        private List<Recipe> recipeList = new List<Recipe>(); // List of known recipes
        private List<Recipe> currentRecipes = new List<Recipe>(); // Last recipes searched

        // Gets all recipes with the given ingredient
        public List<Recipe> GetRecipesByIngredient(string ingredientName)
        {
            List<Recipe> result = new List<Recipe>();

            for (int i = 0; i < recipeList.Count; i++)
            {
                Recipe currentRecipe = recipeList[i];
                bool ingredientFound = false;
                int j = 0;
                while (!ingredientFound && j < currentRecipe.Ingredients.Count)
                {
                    Ingredient currentIngredient = currentRecipe.Ingredients[j];

                    if (currentIngredient.Name == ingredientName)
                    {
                        result.Add(currentRecipe);
                        ingredientFound = true;
                    }
                }
            }

            currentRecipes = result;

            return result;
        }

        // Get the last searched recipes
        public List<Recipe> GetCurrentRecipes()
        {
            return currentRecipes;
        }

        // Deletes given recipe from last searched recipes
        public bool DeleteFromCurrentRecipes(Recipe recipe)
        {
            currentRecipes.Remove(recipe);

            return true;
        }

        // Add a recipe to the known recipes
        public bool AddRecipe(Recipe recipe)
        {
            recipeList.Add(recipe);

            return true;
        }
    }
}
