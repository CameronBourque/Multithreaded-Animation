/*
 *Cameron Bourque
 *4/4/17
 *Multithreading Lab C
 */

import java.awt.*;
import java.awt.geom.*;
/**
 *Creates a meteor object
 */
public class Meteor
{
	private int leftX;
	private int topY;
	private int r;
	public static final int HEIGHT = 100;
	public static final int WIDTH = 200;
	/**
	 *Constructs a meteor at a given coordinate with a given radius
	 *@param x the x coordinate
	 *@param y the y coordinate
	 *@param radius the radius
	 */
	public Meteor(int x, int y, int radius)
	{
		leftX = x;
		topY = y;
		r = radius;
	}
	/**
	 *Moves the meteor in a certain direction
	 *@param dx the movement of the meteor along the x axis
	 *@param dy the movement of the meteor along the y axis
	 */
	public void move(int dx, int dy)
	{
		leftX+=dx;
		topY+=dy;
	}
	/**
	 *Draws the meteor on a given graphics field
	 *@param g2 the graphics field
	 */
	public void draw(Graphics2D g2)
	{
		//draw body
		Ellipse2D.Double body = new Ellipse2D.Double(leftX,topY,2*r,2*r);
		
		//draw crater
		Polygon crater1 = new Polygon(new int[]{leftX+(11*r/12),leftX+(13*r/12),leftX+(7*r/6),leftX+(13*r/12),leftX+(11*r/12),leftX+(5*r/6)},new int[]{topY+(5*r/6),topY+(5*r/6),topY+(r),topY+(7*r/6),topY+(7*r/6),topY+(r)},6);
		Polygon crater2 = new Polygon(new int[]{leftX+(4*r/6),leftX+(5*r/6),leftX+(11*r/12),leftX+(5*r/6),leftX+(4*r/6),leftX+(7*r/12)},new int[]{topY+(r/6),topY+(r/6),topY+(r/3),topY+(r/2),topY+(r/2),topY+(r/6)},6);
		Polygon crater3 = new Polygon(new int[]{leftX+(5*r/12),leftX+(7*r/12),leftX+(2*r/3),leftX+(7*r/12),leftX+(5*r/12),leftX+(r/3)},new int[]{topY+(7*r/6),topY+(7*r/6),topY+(4*r/3),topY+(9*r/6),topY+(9*r/6),topY+(4*r/3)},6);
		Polygon crater4 = new Polygon(new int[]{leftX+(17*r/12),leftX+(19*r/12),leftX+(5*r/3),leftX+(19*r/3),leftX+(17*r/12),leftX+(4*r/3)},new int[]{topY+(r),topY+(r),topY+(7*r/6),topY+(7*r/6),topY+(4*r/3),topY+(4*r/3)},6);
		Polygon crater5 = new Polygon(new int[]{leftX+(15*r/12),leftX+(4*r/3),leftX+(3*r/2),leftX+(4*r/3),leftX+(15*r/12),leftX+(7*r/6)},new int[]{topY+(r/3),topY+(r/3),topY+(r/2),topY+(2*r/3),topY+(2*r/3),topY+(r/2)},6);
		Polygon crater6 = new Polygon(new int[]{leftX+(13*r/12),leftX+(7*r/6),leftX+(15*r/12),leftX+(7*r/6),leftX+(13*r/12),leftX+(r)},new int[]{topY+(4*r/3),topY+(4*r/3),topY+(5*r/6),topY+(5*r/3),topY+(5*r/3),topY+(5*r/6)},6);
		
		g2.setColor(new Color(185,170,168));
		g2.fill(body);
		g2.setColor(new Color(143,120,112));
		g2.fill(crater1);
		g2.fill(crater2);
		g2.fill(crater3);
//		g2.fill(crater4);
		g2.fill(crater5);
		g2.fill(crater6);
	}
}