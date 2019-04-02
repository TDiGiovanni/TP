using Library.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Library.Controllers
{
    [Route("api/subscriber")]
    [ApiController]
    public class SubscriberController : ControllerBase
    {
        private readonly SubscriberContext subscriberContext;

        public SubscriberController(SubscriberContext context)
        {
            subscriberContext = context;

            if (subscriberContext.SubscriberItems.Count() == 0)
            {
                // Create a new item if collection is empty, which means you can't delete all items
                subscriberContext.SubscriberItems.Add(new SubscriberItem());
                subscriberContext.SaveChanges();
            }
        }

        // GET: api/Subscriber
        [HttpGet]
        public async Task<ActionResult<IEnumerable<SubscriberItem>>> GetSubscriberItems()
        {
            return await subscriberContext.SubscriberItems.ToListAsync();
        }

        // GET: api/Subscriber/5
        [HttpGet("{number}")]
        public async Task<ActionResult<SubscriberItem>> GetSubscriberItem(int number)
        {
            var item = await subscriberContext.SubscriberItems.FindAsync(number);

            if (item == null)
                return NotFound();

            return item;
        }

        // POST: api/Subscriber
        [HttpPost]
        public async Task<ActionResult<CommentItem>> PostSubscriberItem(SubscriberItem item)
        {
            subscriberContext.SubscriberItems.Add(item);
            await subscriberContext.SaveChangesAsync();

            return CreatedAtAction(nameof(GetSubscriberItem), new { number = item.number }, item);
        }

        // PUT: api/Subscriber/5
        [HttpPut("{number}")]
        public async Task<IActionResult> PutSubscriberItem(int number, SubscriberItem item)
        {
            if (number != item.number)
            {
                return BadRequest();
            }

            subscriberContext.Entry(item).State = EntityState.Modified;
            await subscriberContext.SaveChangesAsync();

            return NoContent();
        }

        // DELETE: api/Subscriber/5
        [HttpDelete("{number}")]
        public async Task<IActionResult> DeleteSubscriberItem(int number)
        {
            var item = await subscriberContext.SubscriberItems.FindAsync(number);

            if (item == null)
                return NotFound();

            subscriberContext.SubscriberItems.Remove(item);
            await subscriberContext.SaveChangesAsync();

            return NoContent();
        }
    }
}