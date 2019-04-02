using Library.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Library.Controllers
{
    [Route("api/book")]
    [ApiController]
    public class BookController : ControllerBase
    {
        private readonly BookContext bookContext;

        public BookController(BookContext context)
        {
            bookContext = context;

            if (bookContext.BookItems.Count() == 0)
            {
                // Create a new item if collection is empty, which means you can't delete all items
                bookContext.BookItems.Add(new BookItem());
                bookContext.SaveChanges();
            }
        }

        // GET: api/book
        [HttpGet]
        public async Task<ActionResult<IEnumerable<BookItem>>> GetBookItems()
        {
            return await bookContext.BookItems.ToListAsync();
        }

        // GET: api/book/5
        [HttpGet("{isbn}")]
        public async Task<ActionResult<BookItem>> GetBookItem(int isbn)
        {
            var item = await bookContext.BookItems.FindAsync(isbn);

            if (item == null)
                return NotFound();

            return item;
        }

        // POST: api/book
        [HttpPost]
        public async Task<ActionResult<BookItem>> PostBookItem(BookItem item)
        {
            bookContext.BookItems.Add(item);
            await bookContext.SaveChangesAsync();

            return CreatedAtAction(nameof(GetBookItem), new { isbn = item.isbn }, item);
        }

        // PUT: api/book/5
        [HttpPut("{isbn}")]
        public async Task<IActionResult> PutBookItem(int isbn, BookItem item)
        {
            if (isbn != item.isbn)
            {
                return BadRequest();
            }

            bookContext.Entry(item).State = EntityState.Modified;
            await bookContext.SaveChangesAsync();

            return NoContent();
        }

        // DELETE: api/book/5
        [HttpDelete("{isbn}")]
        public async Task<IActionResult> DeleteBookItem(int isbn)
        {
            var item = await bookContext.BookItems.FindAsync(isbn);

            if (item == null)
                return NotFound();

            bookContext.BookItems.Remove(item);
            await bookContext.SaveChangesAsync();

            return NoContent();
        }
    }
}