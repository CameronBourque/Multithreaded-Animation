/*
 *Cameron Bourque
 *4/4/17
 *Multithreading Lab C
 */
import java.awt.*;
import java.awt.geom.*;
/**
 *Creates a spaceship object
 */
public class Spaceship
{
	private int leftX;
	private int topY;
	public static final int HEIGHT = 100;
	public static final int WIDTH = 200;
	/**
	 *Constructs a spaceship at given coordinates
	 *@param x the x coordinate
	 *@param y the y coordinate
	 */
	public Spaceship(int x, int y)
	{
		leftX = x;
		topY = y;
	}
	/**
	 *Moves the spaceship in a certain direction
	 *@param dx the movement of the spaceship along the x axis
	 *@param dy the movement of the spaceship along the y axis
	 */
	public void move(int dx, int dy)
	{
		leftX+=dx;
		topY+=dy;
	}
	/**
	 *Draws the spaceship on a given graphics field
	 *@param g2 the given graphics field
	 */
	public void draw(Graphics2D g2)
	{
		//draw windshield
		Polygon window = new Polygon(new int[]{leftX+175,leftX+195,leftX+215,leftX+175},new int[]{topY+10,topY+10,topY+20,topY+20},4);
		//draw fin
		Polygon fin = new Polygon(new int[]{leftX+25,leftX+50,leftX+75,leftX+25},new int[]{topY-25,topY-20,topY,topY},4);
		Line2D.Double wing = new Line2D.Double(leftX+50,topY+30,leftX+125,topY+30);
		//draw body
		Rectangle body = new Rectangle(leftX+25,topY,150,40);
		Polygon head = new Polygon(new int[]{leftX+175,leftX+225,leftX+175},new int[]{topY,topY+25,topY+40},3);
		//draw blaster
		Polygon rocket = new Polygon(new int[]{leftX,leftX+25,leftX+25,leftX},new int[]{topY+10,topY+15,topY+25,topY+30},4);
		
		g2.setColor(Color.LIGHT_GRAY);
		g2.fill(rocket);
		g2.setColor(Color.WHITE);
		g2.fill(fin);
		g2.fill(body);
		g2.fill(head);
		g2.setColor(Color.BLACK);
		g2.draw(wing);
		g2.setColor(Color.BLUE);
		g2.fill(window);
	}
	/**
	 *Returns the x coordinate of the spaceship
	 *@return the x coordinate of the spaceship
	 */
	public int getX()
	{
		return leftX;
	}
}