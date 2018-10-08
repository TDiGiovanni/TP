package dico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FastDictionaryTest {
	private FastDictionary dico;

	@Before
	public void setUp() throws Exception {
		dico = new FastDictionary();
	}

	@Test
	public void addElementToDico() {
		assertTrue(dico.isEmpty());
		
		dico.put(1, "un");
		dico.put(13, "treize");
		dico.put(14, "quatorze");
		
		assertFalse(dico.isEmpty());
		
		dico.put(12, "douze");
		
		assertFalse(dico.mustGrow());
		assertTrue(dico.containsKey(12));
		assertEquals(dico.get(12), "douze");
		assertEquals(dico.newIndexOf(12),dico.indexOf(12));
	}
	
	@Test
	public void checkNonExistantKey() {
		assertEquals(-1, dico.indexOf(1));
		assertEquals(dico.get(1), null);
		assertFalse(dico.containsKey(1));
	}
	
	@Test
	public void createSizedDico() {
		dico = new FastDictionary(1);
		
		assertTrue(dico.isEmpty());
		assertFalse(dico.mustGrow());
		
		dico.put(1, "un");
		
		assertTrue(dico.mustGrow());
		assertTrue(dico.containsKey(1));
		assertEquals(dico.get(1), "un");
		assertEquals(dico.newIndexOf(1),dico.indexOf(1));
		
		dico.put(2, "deux");
		assertFalse(dico.mustGrow());
		assertTrue(dico.containsKey(2));
		assertEquals(dico.get(2), "deux");
		assertEquals(dico.newIndexOf(2),dico.indexOf(2));
	}
	
	@Test
	public void addAlreadyExistingKey() {
		dico.put(1, "un");
		
		dico.put(1, "deux");
		
		assertFalse(dico.mustGrow());
		assertTrue(dico.containsKey(1));
		assertEquals(dico.get(1), "deux");
	}
}
