/*
 *Cameron Bourque
 *4/4/17
 *Multithreading Lab C
 */
import java.awt.*;
import java.awt.geom.*;
/**
 *Creates a UFO object
 */
public class UFO
{
	private int leftX;
	private int topY;
	public static final int HEIGHT = 100;
	public static final int WIDTH = 200;
	/**
	 *Constructs a UFO object with given coordinates
	 *@param x the x coordinate
	 *@param y the y coordinate
	 */
	public UFO(int x, int y)
	{
		leftX = x;
		topY = y;
	}
	/**
	 *Moves the UFO in a certain direction
	 *@param dx the distance to move the UFO along the x axis
	 *@param dy the distance to move the UFO along the y axis
	 */
	public void move(int dx, int dy)
	{
		leftX+=dx;
		topY+=dy;
	}
	/**
	 *Draws the UFO on a given graphics field
	 *@param g2 the graphics field
	 */
	public void draw(Graphics2D g2)
	{
		//draw windshield
		Ellipse2D.Double window = new Ellipse2D.Double(leftX+50,topY,75,50);
		
		//draw body
		Ellipse2D.Double body = new Ellipse2D.Double(leftX,topY+25,200,35);
		//draw lights
		Rectangle light1 = new Rectangle(leftX+20,topY+37,10,10);
		Rectangle light2 = new Rectangle(leftX+50,topY+37,10,10);
		Rectangle light3 = new Rectangle(leftX+80,topY+37,10,10);
		Rectangle light4 = new Rectangle(leftX+110,topY+37,10,10);
		Rectangle light5 = new Rectangle(leftX+140,topY+37,10,10);
		Rectangle light6 = new Rectangle(leftX+170,topY+37,10,10);
		
		//fill shapes
		g2.setColor(Color.CYAN);
		g2.fill(window);
		g2.setColor(Color.DARK_GRAY);
		g2.fill(body);
		g2.setColor(Color.YELLOW);
		g2.fill(light1);
		g2.fill(light2);
		g2.fill(light3);
		g2.fill(light4);
		g2.fill(light5);
		g2.fill(light6);
	}
	/**
	 *Returns the x coordinate of the UFO
	 *@return the x coordinate of the UFO
	 */
	public int getX()
	{
		return leftX;
	}
}