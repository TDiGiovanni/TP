package tpMocks;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.mockito.Mock;
import org.mockito.AdditionalMatchers;
import org.mockito.ArgumentMatcher;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ITest {
	@Mock I mock;
	
	@Test
	public void testDefaultValue() throws Exception {
		assertEquals(mock.methodeInt(), 0);
	}
	
	@Test
	public void testReturnValue() throws Exception {
		when (mock.methodeInt()).thenReturn(1, 2, 3, 4);
		
		assertEquals(mock.methodeInt(), 1);
		assertEquals(mock.methodeInt(), 2);
		assertEquals(mock.methodeInt(), 3);
		assertEquals(mock.methodeInt(), 4);
	
		verify (mock, times(4)).methodeInt();
		
		assertEquals(mock.methodeInt(), 4);
	}
	
	@Test(expected=Exception.class)
	public void testReturnException() throws Exception {
		when (mock.methodeInt()).thenThrow(new Exception());
		
		mock.methodeInt();
	}
	
	@Test(expected=Exception.class)
	public void testVoidException() throws Exception {
		doThrow (new Exception()). when (mock).methodeVoid();
		
		mock.methodeVoid();
	}
	
	@Test
	public void testParams() {
		when (mock.methodeParam(3)).thenReturn(3);
		when (mock.methodeParam(5)).thenReturn(10);
		
		assertEquals(mock.methodeParam(1), 0);
		assertEquals(mock.methodeParam(3), 3);
		assertEquals(mock.methodeParam(5), 10);
	}
	
	@Test
	public void testMatchersInt() {
		//when (mock.methodeParam(gt(10))).thenReturn(42);
		//when (mock.methodeParam(leq(10))).thenReturn(0);
		
		assertEquals(mock.methodeParam(3), 0);
		assertEquals(mock.methodeParam(12), 42);
	}
	
	@Test
	public void testMatchersList() {
		
	}
}
