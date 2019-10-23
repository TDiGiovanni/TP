using Android.App;
using Android.OS;

namespace TP1_Shared.Droid
{
    [Activity(Label = "TP1_Shared", MainLauncher = true, Icon = "@mipmap/icon")]
    public class MainActivity : Activity
    {
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.Main);

            // Faites les appels de vos fonctions pour le projet partage ici : 
            
        }
    }
}

