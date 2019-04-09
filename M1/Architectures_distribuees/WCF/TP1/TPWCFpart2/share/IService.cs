using System.Collections.Generic;
using System.Runtime.Serialization;
using System.ServiceModel;

namespace share
{
    [ServiceContract]
    public interface IService
    {
        [OperationContract]
        List<Recipe> GetRecipesByIngredient(string ingredientName);

        [OperationContract]
        List<Recipe> GetCurrentRecipes();

        [OperationContract]
        bool DeleteFromCurrentRecipes(Recipe recipe);

        [OperationContract]
        bool AddRecipe(Recipe recipe);
    }

    [DataContract]
    public class Ingredient
    {
        string name;

        [DataMember]
        public string Name
        {
            get { return name; }
            set { name = value; }
        }
    }

    [DataContract]
    public class Recipe
    {
        string title;
        List<Ingredient> ingredients;

        [DataMember]
        public string Title
        {
            get { return title; }
            set { title = value; }
        }

        [DataMember]
        public List<Ingredient> Ingredients
        {
            get { return ingredients; }
            set { ingredients = value; }
        }
    }
}
