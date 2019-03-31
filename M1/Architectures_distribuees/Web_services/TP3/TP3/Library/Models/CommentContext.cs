using Microsoft.EntityFrameworkCore;

namespace Library.Models
{
    public class CommentContext : DbContext
    {
        public CommentContext(DbContextOptions<CommentContext> options) : base(options)
        { }

        public DbSet<CommentItem> CommentItems { get; set; }
    }
}