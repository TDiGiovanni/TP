using System.Collections.Generic;

namespace share
{
    public class Service : IService
    {
        private List<Recipe> currentRecipes = new List<Recipe>();

        public List<Recipe> GetRecipesByIngredient(string ingredientName)
        {
            List<Recipe> result = new List<Recipe>();

            //TODO: search recipes

            currentRecipes = result;

            return result;
        }

        public List<Recipe> GetCurrentRecipes()
        {
            return currentRecipes;
        }

        public bool DeleteFromCurrentRecipes(Recipe recipe)
        {
            //TODO: delete recipe

            return true;
        }

        public bool AddRecipe(Recipe recipe)
        {
            //TODO: add to db

            return true;
        }
    }
}
