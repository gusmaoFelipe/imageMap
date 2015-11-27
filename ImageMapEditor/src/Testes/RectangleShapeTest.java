package Testes;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Test;

import imagemap.graphics.CircleShape;
import imagemap.graphics.RectangleShape;

public class RectangleShapeTest {
	// 0 0 0 0 (retangulo nulo)
	@Test
	public void test1() {
		RectangleShape rect = new RectangleShape(0, 0, 0, 0);
		Rectangle rectangle = rect.getRectangle();
		int result = (int) (rectangle.getHeight() + rectangle.getWidth());
		assertEquals(result, 0);
	}

	// 1 1 3 3 (positivos)
	@Test
	public void test2() {
		RectangleShape rect = new RectangleShape(1, 1, 3, 3);
		Rectangle rectangle = rect.getRectangle();
		int result = (int) (rectangle.getHeight() + rectangle.getWidth());
		assertEquals(result, 4);
	}

	// -1 -1 -3 -3 (negativos)
	@Test
	public void test3() {
		RectangleShape rect = new RectangleShape(-1, -1, -3, -3);
		Rectangle rectangle = rect.getRectangle();
		int result = (int) (rectangle.getHeight() + rectangle.getWidth());
		assertEquals(result, 4);
	}

	// 4 4 -3 -3 (x e y maiores que x1 e y1)
	@Test
	public void test4() {
		RectangleShape rect = new RectangleShape(4, 4, -3, -3);
		Rectangle rectangle = rect.getRectangle();
		int result = (int) (rectangle.getHeight() + rectangle.getWidth());
		assertEquals(result, 14);
	}

	// testando o método matches
	// forma geométrica diferente (círculo)
	@Test
	public void test5() {
		RectangleShape rect = new RectangleShape(4, 4, -3, -3);
		CircleShape circulo = new CircleShape(new Point(0, 0), 2);
		assertFalse(rect.matches(circulo));
	}

	// forma retangulo inscrito no retangulo base (retangulos diferentes)
	@Test
	public void test6() {
		RectangleShape retangulo = new RectangleShape(4, 4, -3, -3);
		RectangleShape retangulo2 = new RectangleShape(1, 1, 0, 0);
		assertFalse(retangulo.matches(retangulo2));
	}

	// forma retangulo (retangulos opostos -- deve dar match)
	@Test
	public void test7() {
		RectangleShape retangulo = new RectangleShape(4, 4, -3, -3);
		RectangleShape retangulo2 = new RectangleShape(-3, -3, 4, 4);
		assertTrue(retangulo.matches(retangulo2));
	}

	// forma retangulo (retangulos iguais -- deve dar match)
	@Test
	public void test8() {
		RectangleShape retangulo = new RectangleShape(4, 4, -3, -3);
		RectangleShape retangulo2 = new RectangleShape(4, 4, -3, -3);
		assertTrue(retangulo.matches(retangulo2));
	}

	// Método contains()
	// Ponto interno [1, 1]
	@Test
	public void test9() {
		RectangleShape retangulo = new RectangleShape(4, 4, -3, -3);
		assertTrue(retangulo.contains(1, 1));
	}

	// Ponto externo [5, 5]
	@Test
	public void test10() {
		RectangleShape retangulo = new RectangleShape(4, 4, -3, -3);
		assertFalse(retangulo.contains(5, 5));
	}

	// Método cornerContains()
	// ponto na esquina [4, 4]
	@Test
	public void test11() {
		RectangleShape retangulo = new RectangleShape(4, 4, -3, -3);
		assertTrue(retangulo.cornerContains(new Point(4, 4)));
	}

	// Ponto na extremidade do retangulo [4, 0]
	@Test
	public void test12() {
		RectangleShape retangulo = new RectangleShape(4, 4, -3, -3);
		assertFalse(retangulo.contains(4, 0));
	}
	
	//Método move()
	//movendo retangulo com direcao positiva
	@Test
	public void test13() {
		RectangleShape retangulo = new RectangleShape(4, 4, -3, -3);
		retangulo.move(5, 5);
		assertTrue(retangulo.cornerContains(new Point(9, 9)));
	}
	
	//movendo retangulo com direcao negativa
		@Test
		public void test14() {
			RectangleShape retangulo = new RectangleShape(4, 4, -3, -3);
			retangulo.move(-5, -5);
			assertTrue(retangulo.cornerContains(new Point(-8, -8)));
		}

}
