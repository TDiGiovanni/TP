package tpMocks;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest ({C.class})
public class CTest {
	@Mock C mock;
	
	@Test
	public void testM1() {
		PowerMockito.mockStatic(C.class);
		
		Mockito.when (C.m1()).thenReturn (1);
		
		assertEquals(C.m1(), 1); 
	}
	
	@Test
	public void testM2() {
		Mockito.when (mock.m2(4)).thenReturn (1);
		
		assertEquals(mock.m2(4), 1); 
	}
}
