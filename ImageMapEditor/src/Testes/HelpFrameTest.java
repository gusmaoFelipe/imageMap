package Testes;

import static org.junit.Assert.*;
import imagemap.HelpFrame;

import org.junit.Test;

public class HelpFrameTest {

	//testando o método getInstance()
	@Test
	public void test1() {
		HelpFrame helpFrame = HelpFrame.getInstance();
		assertTrue(helpFrame!=null);
	}
	
	//testando se os objetos helpFrame e helpFrame2 são o mesmo objeto
	@Test
	public void test2() {
		HelpFrame helpFrame = HelpFrame.getInstance();
		HelpFrame helpFrame2 = HelpFrame.getInstance();
		assertEquals(helpFrame,helpFrame2);
	}
	
	//os objetos helpFrame e helpFrame2 são o mesmo objeto e não nulos
	@Test
	public void test3() {
		HelpFrame helpFrame = HelpFrame.getInstance();
		HelpFrame helpFrame2 = HelpFrame.getInstance();
		assertTrue((helpFrame.equals(helpFrame2))&&(helpFrame!=null));
	}

}
