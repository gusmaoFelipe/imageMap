package Testes;

import static org.junit.Assert.*;

import javax.swing.text.DefaultStyledDocument;

import org.junit.Test;

import imagemap.panels.HTMLPanel;

public class HTMLPanelTest {

	// verificando se o objeto htmlPanel retornou editable = false
	@Test
	public void test1() {
		HTMLPanel object = new HTMLPanel(new DefaultStyledDocument());
		assertEquals(false, object.isEditable());
	}

	//Método getLineNumbers()

	// o arquivo apenas foi criado, entao tem uma linha
	@Test
	public void test2() {
		HTMLPanel object = new HTMLPanel(new DefaultStyledDocument());
		String saidaCorreta = "1" + " \n";
		assertEquals(saidaCorreta, object.getLineNumbers());
	}
	
	//Método setText()
	//testando se após a insercao do texto, o getLines aumenta
	@Test
	public void test3(){
		HTMLPanel object = new HTMLPanel(new DefaultStyledDocument());
		String entrada = "teste";
		object.setText(entrada);
		assertTrue(object.getLineNumbers().length() > 2);
	}

}
