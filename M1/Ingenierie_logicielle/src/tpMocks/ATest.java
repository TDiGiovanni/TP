package tpMocks;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ATest {
	@Spy A spy;

	@Test
	public void testMethods() {
		assertEquals(spy.m1(), 42);
		assertEquals(spy.m2(3), 9);
		
		verify (spy).m1();
		verify (spy).m2(3);
	}
	
	@Test
	public void testM2() {
		when (spy.m2(42)).thenReturn(0);
		
		assertEquals(spy.m2(0), 0);
		assertEquals(spy.m2(5), 25);
		assertEquals(spy.m2(42), 0);
	}

}
