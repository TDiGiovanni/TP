using Xamarin.Forms;
using XamarinMessenger.Models;

public class MapItemTemplateSelector : DataTemplateSelector
{
    public DataTemplate DefaultTemplate { get; set; }
    public DataTemplate XamarinTemplate { get; set; }

    protected override DataTemplate OnSelectTemplate(object item, BindableObject container)
    {
        return ((Item)item).student_message.Contains("message 3") ? XamarinTemplate : DefaultTemplate;
    }
}