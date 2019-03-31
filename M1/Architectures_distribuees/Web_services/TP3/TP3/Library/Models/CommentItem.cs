namespace Library.Models
{
    public class CommentItem
    {
        private static int idCount = 0;

        public int id;
        public SubscriberItem author;   // Author of the comment
        public string text;         // Actual comment

        // Constructors
        public CommentItem()
        {
            idCount++;

            this.id = idCount;
            this.author = new SubscriberItem();
            this.text = "";
        }

        public CommentItem(SubscriberItem author, string text)
        {
            idCount++;

            this.id = idCount;
            this.author = author;
            this.text = text;
        }
    }
}
