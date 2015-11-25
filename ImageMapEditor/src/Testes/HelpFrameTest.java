package Testes;

import static org.junit.Assert.*;
import imagemap.HelpFrame;

import org.junit.Test;

public class HelpFrameTest {

	@Test
	public void test1() {
		HelpFrame helpFrame = HelpFrame.getInstance();
		assertTrue(helpFrame!=null);
	}
	
	@Test
	public void test2() {
		HelpFrame helpFrame = HelpFrame.getInstance();
		HelpFrame helpFrame2 = HelpFrame.getInstance();
		assertEquals(helpFrame,helpFrame2);
	}
	
	@Test
	public void test3() {
		HelpFrame helpFrame = HelpFrame.getInstance();
		HelpFrame helpFrame2 = HelpFrame.getInstance();
		assertTrue((helpFrame.equals(helpFrame2))&&(helpFrame!=null));
	}
	
	@Test
	public void test4() {
		
	}
	
	
	@Test
	public void test5() {
	}

}
