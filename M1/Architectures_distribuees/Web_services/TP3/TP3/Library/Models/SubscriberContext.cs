using Microsoft.EntityFrameworkCore;

namespace Library.Models
{
    public class SubscriberContext : DbContext
    {
        public SubscriberContext(DbContextOptions<SubscriberContext> options) : base(options)
        { }

        public DbSet<SubscriberItem> SubscriberItems { get; set; }
    }
}