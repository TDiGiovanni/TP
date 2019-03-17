using System.Web.Services;

namespace FirstWebService
{
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Pour autoriser l'appel de ce service Web depuis un script à l'aide d'ASP.NET AJAX :
    //[System.Web.Script.Services.ScriptService]
    public class TimeWebService : System.Web.Services.WebService
    {
        [WebMethod]
        public System.DateTime getTime()
        {
            return System.DateTime.Now;
        }
    }
}
