package dico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrderedDictionaryTest {
	private OrderedDictionary dico;

	@Before
	public void setUp() throws Exception {
		dico = new OrderedDictionary();
	}
	
	@Test
	public void addElementToDico() {
		assertTrue(dico.isEmpty());
		
		dico.put(1, "un");
		dico.put(13, "treize");
		dico.put(14, "quatorze");
		
		assertFalse(dico.isEmpty());
		
		dico.put(12, "douze");
		
		assertEquals(dico.keys.length, 4);
		assertTrue(dico.containsKey(12));
		assertEquals(dico.get(12), "douze");
		assertEquals(dico.indexOf(12), 3);
		assertEquals(dico.newIndexOf(12), 3);
	}
	
	@Test
	public void checkNonExistantKey() {
		assertEquals(-1, dico.indexOf(1));
		assertEquals(dico.get(1), null);
		assertFalse(dico.containsKey(1));
	}
	
	@Test
	public void createNonEmptyDico() {
		dico = new OrderedDictionary(10);
		
		assertTrue(dico.isEmpty());
		assertEquals(dico.keys.length, 10);
		
		dico.put(1, "un");
		
		assertEquals(dico.keys.length, 10);
		assertTrue(dico.containsKey(1));
		assertEquals(dico.get(1), "un");
		assertEquals(dico.indexOf(1), 0);
		assertEquals(dico.newIndexOf(1), 0);
	}
	
	@Test
	public void addAlreadyExistingKey() {
		dico.put(1, "un");
		
		dico.put(1, "deux");
		
		assertEquals(dico.keys.length, 1);
		assertTrue(dico.containsKey(1));
		assertEquals(dico.get(1), "deux");
	}
	
}
