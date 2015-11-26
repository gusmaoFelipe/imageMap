package Testes;

import static org.junit.Assert.*;
import imagemap.graphics.CircleShape;

import java.awt.Point;

import org.junit.Test;

// Testes para o m�doto contains

public class CircleShapeTest {

	//Ponto central
	@Test
	public void test1() {
		int x=5;
		int y=5;
		//indica a posicao do ponto central
		Point ponto = new Point(x,y);
		int raio=5;
		//indica o raio do raio
		CircleShape circle = new CircleShape(ponto,raio);
		assertTrue(circle.contains(5, 5));
	}
	
	//Ponto x<0
	@Test
	public void test2() {
		int x=5;
		int y=5;
		Point ponto = new Point(x,y);
		int raio=5;
		CircleShape circle = new CircleShape(ponto,raio);
		assertFalse(circle.contains(-5, 5));
	}

	//Ponto y<0
	@Test
	public void test3() {
		int x=5;
		int y=5;
		Point ponto = new Point(x,y);
		int raio=5;
		CircleShape circle = new CircleShape(ponto,raio);
		assertFalse(circle.contains(5, -5));
	}

	//Ponto x<0 e y<0
	@Test
	public void test4() {
		int x=5;
		int y=5;
		Point ponto = new Point(x,y);
		int raio=5;
		CircleShape circle = new CircleShape(ponto,raio);
		assertFalse(circle.contains(-5,-5));
	}

	//Ponto x>0; y>0; por�m fora do circulo
	@Test
	public void test5() {
		int x=5;
		int y=5;
		Point ponto = new Point(x,y);
		int raio=5;
		CircleShape circle = new CircleShape(ponto,raio);
		assertFalse(circle.contains(1, 1));
	}
	

}
