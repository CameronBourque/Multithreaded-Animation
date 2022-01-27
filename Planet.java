/*
 *Cameron Bourque
 *4/4/17
 *Multithreading Lab C
 */
import java.awt.*;
import java.awt.geom.*;
/**
 *Creates a new planet object
 */
public class Planet
{
	private int leftX;
	private int topY;
	private int r;
	public static final int HEIGHT = 100;
	public static final int WIDTH = 200;
	/**
	 *Constructs a planet with given coordinates and a size
	 *@param x the x coordinate
	 *@param y the y coordinate
	 *@param radius the size
	 */
	public Planet(int x, int y, int radius)
	{
		leftX = x;
		topY = y;
		r = radius;
	}
	/**
	 *Draws the planet object on a given graphics field
	 *@param g2 the graphics field
	 */
	public void draw(Graphics2D g2)
	{
		//draw star glistening
		Polygon star = new Polygon(new int[]{leftX+(r),leftX+(5*r/4),leftX+(2*r),leftX+(5*r/4),leftX+(r),leftX+(3*r/4),leftX,leftX+(3*r/4)},new int[]{topY,topY+(3*r/4),topY+(r),topY+(5*r/4),topY+(2*r),topY+(5*r/4),topY+(r),topY+(3*r/4)},8);
		Ellipse2D.Double bulb = new Ellipse2D.Double(leftX+(r/2),topY+(r/2),r,r);
		
		g2.setColor(new Color(217,217,217));
		g2.fill(star);
		g2.setColor(Color.WHITE);
		g2.fill(bulb);
	}
}