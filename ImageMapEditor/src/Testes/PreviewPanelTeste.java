package Testes;

import static org.junit.Assert.*;

import imagemap.panels.ImagePanel;
import imagemap.panels.PreviewPanel;

import org.junit.Test;

//setPanel e getPanel
public class PreviewPanelTeste {

	@Test
	public void test1() {
		ImagePanel imagePanel=null;
		PreviewPanel preview = new PreviewPanel(imagePanel);
		assertEquals(null, preview.getPanel());
	}
	
	@Test
	public void test2() {
		ImagePanel imagePanel = new ImagePanel(null, null);
		PreviewPanel preview = new PreviewPanel(imagePanel);
		assertEquals(imagePanel, preview.getPanel());
	}
	
	@Test
	public void test3() {
		ImagePanel imagePanel = new ImagePanel(null, null);
		PreviewPanel preview = new PreviewPanel(imagePanel);
		preview.setPanel(null);
		assertEquals(null, preview.getPanel());
	}
	
	@Test
	public void test4(){
		ImagePanel imagePanel=null;
		PreviewPanel preview = new PreviewPanel(imagePanel);
		ImagePanel imagePanel2=new ImagePanel(null, null);
		preview.setPanel(imagePanel2);
		assertEquals(imagePanel2, preview.getPanel());
	}
	
	@Test
	public void test5() {
		ImagePanel imagePanel=new ImagePanel(null, null);
		PreviewPanel preview = new PreviewPanel(imagePanel);
		preview.setPanel(preview.getPanel());
		assertEquals(imagePanel, preview.getPanel());
	}
	
}
