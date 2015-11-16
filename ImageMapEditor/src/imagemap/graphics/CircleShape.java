/**
 * 
 */
package imagemap.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;

/**
 * @author Niklas Miroll
 * @author Jean Henrique Ferreira
 * @author Felipe paes Gusmão
 */
public class CircleShape extends AbstractShape {
	private Point circCent;
	private int circR;

	/**
	 * Constructor for circle shapes
	 * 
	 * @param m
	 * @param r
	 */
	public CircleShape(Point p, int r) {
		type = TYPE_CIRC;
		circCent = p;
		circR = r;
		hashCode();
	}

	/**
	 * @see imagemap.graphics.AbstractShape#matches(imagemap.graphics.AbstractShape)
	 */
	@Override
	public boolean matches(AbstractShape tmp) {
		if (this.getType() != tmp.getType()) {
			return false;
		}
		CircleShape tmp2 = (CircleShape) tmp;
		if (circCent.getX() == tmp2.getCenter().getX() && circCent.getY() == tmp2.getCenter().getY()
				&& circR == tmp2.getRadius()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @see imagemap.graphics.AbstractShape#contains(int, int)
	 */
	@Override
	public boolean contains(int x, int y) {
		int x_tmp = (int) circCent.getX();
		int y_tmp = (int) circCent.getY();
		double dist = Math.sqrt((Math.pow((x - x_tmp), 2) + Math.pow((y - y_tmp), 2)));
		if (dist < circR) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @see imagemap.graphics.AbstractShape#cornerContains(java.awt.Point)
	 */
	@Override
	public boolean cornerContains(Point p) {
		Rectangle tmp_circ_rect = new Rectangle(circCent.x + circR - 3, circCent.y - 3, 6, 6);
		if (tmp_circ_rect.contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @see imagemap.graphics.AbstractShape#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g2) {
		float dashArray[] = { 4.0f };
		Stroke stroke2 = g2.getStroke();
		BasicStroke bs = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 3.0f, dashArray, 0.0f);

		int xc = (int) circCent.getX();
		int yc = (int) circCent.getY();
		int r = circR;

		// draw circle with lineColor and white dotted line
		g2.setColor(lineColor);
		g2.drawOval(xc - r, yc - r, r * 2, r * 2);
		g2.setStroke(bs);
		g2.setColor(Color.white);
		g2.drawOval(xc - r, yc - r, r * 2, r * 2);
		g2.setColor(neutralColor);
		g2.fillOval(xc - r, yc - r, r * 2, r * 2);

		// draw box for resize
		g2.setStroke(stroke2);
		g2.setColor(lineColor);
		g2.fillRect(xc + r - 2, yc - 2, 4, 4);
		g2.setColor(Color.white);
		g2.drawRect(xc + r - 2, yc - 2, 4, 4);
	}

	/**
	 * @see imagemap.graphics.AbstractShape#move(int, int)
	 */
	@Override
	public void move(int xdir, int ydir) {
		circCent.setLocation((int) circCent.getX() + xdir, (int) circCent.getY() + ydir);
	}

	/**
	 * @see imagemap.graphics.AbstractShape#movePoint(java.awt.Point, int, int)
	 */
	@Override
	public void movePoint(Point p, int xdir, int ydir) {
		double xcomponent = p.getX() - circCent.getX() + xdir;
		double ycomponent = p.getY() - circCent.getY() + ydir;
		circR = (int) Math.sqrt((Math.pow(xcomponent, 2) + Math.pow(ycomponent, 2)));
		if (circR < 4) {
			circR = 4;
		}
	}

	/**
	 * @see imagemap.graphics.AbstractShape#clone()
	 */
	@Override
	public CircleShape clone() {
		return new CircleShape(new Point((int) circCent.getX(), (int) circCent.getY()), circR);
	}

	/**
	 * @see imagemap.graphics.AbstractShape#toString()
	 */
	@Override
	public String toString() {
		String s = "Circle: [center: " + "(x: " + circCent.getX() + "; y: " + circCent.getY();
		s += "), radius: " + circR + "]";
		return s;
	}

	/**
	 * @see imagemap.graphics.AbstractShape#getSpecificHTML()
	 */
	@Override
	public String getSpecificHTML() {
		return "circle\" coords=\"" + (int) circCent.getX() + "," + (int) circCent.getY() + "," + circR + "\" ";
	}

	/**
	 * @see imagemap.graphics.AbstractShape#getResizeCursor(java.awt.Point)
	 */
	@Override
	public int getResizeCursor(Point p) {
		return Cursor.E_RESIZE_CURSOR;
	}

	/**
	 * 
	 * @return radius of circle if it's a circle
	 */
	public int getRadius() {
		int radius = 0 + circR;
		return radius;
	} // end of getRadius()

	/**
	 * 
	 * @return center of circle if it's a circle
	 */
	public Point getCenter() {
		return (Point) circCent.clone();
	} // end of getCenter()

	/**
	 * @see imagemap.graphics.AbstractShape#getCoords()
	 */
	@Override
	public String getCoords() {
		return circCent.x + "," + circCent.y + "," + circR;
	}

	/**
	 * @see imagemap.graphics.AbstractShape#getTypeName()
	 */
	@Override
	public String getTypeName() {
		return "circle";
	}

	/**
	 * @see imagemap.graphics.AbstractShape#scaleShape(double)
	 */
	@Override
	public void scale(float scale) {
		circCent = new Point(Math.round(circCent.x * scale), Math.round(circCent.y * scale));
		circR = Math.round(circR * scale);
	}

}
