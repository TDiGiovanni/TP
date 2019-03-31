namespace Library.Models
{
    public class CommentItem
    {
        public SubscriberItem author;   // Author of the comment
        public string text;         // Actual comment

        // Constructors
        public CommentItem()
        {
            this.author = new SubscriberItem();
            this.text = "";
        }

        public CommentItem(SubscriberItem author, string text)
        {
            this.author = author;
            this.text = text;
        }
    }
}
