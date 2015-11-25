package Testes;

import junit.framework.*;
import imagemap.ImageMap;

import org.junit.Test;

//Testes para o método validarArquivo

public class ImageMapTeste extends TestCase{
	ImageMap imageMap = new ImageMap("teste");
	
	@Test
	public void test1() {
		assertTrue(imageMap.validarArquivo("nome.jpg"));
	}

	@Test
	public void test2() {
		assertTrue(this.imageMap.validarArquivo("nome.jpeg"));
	}

	@Test
	public void test3() {
		assertTrue(this.imageMap.validarArquivo("nome.png"));
	}

	@Test
	public void test4() {
		assertTrue(this.imageMap.validarArquivo("nome.gif"));
	}

	@Test
	public void test5() {
		assertTrue(this.imageMap.validarArquivo("nome.bmp"));
	}

	@Test
	public void test6() {
		assertFalse(this.imageMap.validarArquivo("nome.doc"));
	}

}
