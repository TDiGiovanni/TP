using System;
using System.Collections.Generic;
using System.Text;

namespace XamarinMessenger.Models
{
    public enum MenuItemType
    {
        Messages,
        Carte,
        About
    }
    public class HomeMenuItem
    {
        public MenuItemType Id { get; set; }

        public string Title { get; set; }
    }
}
