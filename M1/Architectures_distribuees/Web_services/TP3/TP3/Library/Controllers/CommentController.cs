using Library.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Library.Controllers
{
    [Route("api/comment")]
    [ApiController]
    public class CommentController : ControllerBase
    {
        private readonly CommentContext commentContext;

        public CommentController(CommentContext context)
        {
            commentContext = context;

            if (commentContext.CommentItems.Count() == 0)
            {
                // Create a new item if collection is empty, which means you can't delete all items
                commentContext.CommentItems.Add(new CommentItem());
                commentContext.SaveChanges();
            }
        }

        // GET: api/Comment
        [HttpGet]
        public async Task<ActionResult<IEnumerable<CommentItem>>> GetCommentItems()
        {
            return await commentContext.CommentItems.ToListAsync();
        }

        // GET: api/Comment/5
        [HttpGet("{id}")]
        public async Task<ActionResult<CommentItem>> GetCommentItem(int id)
        {
            var item = await commentContext.CommentItems.FindAsync(id);

            if (item == null)
                return NotFound();

            return item;
        }

        // POST: api/Comment
        [HttpPost]
        public async Task<ActionResult<CommentItem>> PostCommentItem(CommentItem item)
        {
            commentContext.CommentItems.Add(item);
            await commentContext.SaveChangesAsync();

            return CreatedAtAction(nameof(GetCommentItem), new { id = item.id }, item);
        }

        // PUT: api/Comment/5
        [HttpPut("{id}")]
        public async Task<IActionResult> PutCommentItem(int id, CommentItem item)
        {
            if (id != item.id)
            {
                return BadRequest();
            }

            commentContext.Entry(item).State = EntityState.Modified;
            await commentContext.SaveChangesAsync();

            return NoContent();
        }

        // DELETE: api/Comment/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteCommentItem(int id)
        {
            var item = await commentContext.CommentItems.FindAsync(id);

            if (item == null)
                return NotFound();

            commentContext.CommentItems.Remove(item);
            await commentContext.SaveChangesAsync();

            return NoContent();
        }
    }
}