/*
 *Cameron Bourque
 *4/4/17
 *Multithreading Lab C
 */
import javax.swing.JComponent;
import java.awt.Graphics2D;
/**
 *Creates a moving spaceship that allows a spaceship to animate
 */
public class MovingSpaceship extends Spaceship
{
   /**
      Creates a new MovingSpaceship Instance
      @param leftX the x coordinate of the top left corner
      @param topY the y coordinate of the top left corner
      @param step Step in pixels the spaceship will move each time
      @param delay The delay to wait between each step
      @param steps How many times the spaceship will move
      @param direction In which direction the spaceship will move
      @param component The component
    */
   public MovingSpaceship(int leftX, int topY, int step, int delay, int steps,
         int direction, JComponent component)
   {
      super(leftX, topY);
      this.step = step;
      this.delay = delay;
      this.steps = steps;
      this.direction = direction;
      this.component = component;
   }
   
   /**
    * Adjusts the Spaceship's x and y locations based on the direction it is going.  Moves it a fixed
    * number of steps.
    */
   public void animate()
         throws InterruptedException
   {
      for (int i = 0; i < steps; i++)
      {
         int x = 0;
         int y = 0;
         switch(direction)
         {
            case NORTH: y = -1 * step;
               break;
            case SOUTH: y = step;
               break;
            case EAST: x = step;
               break;
            case WEST: x = -1 * step;
         }
         
         move(x, y);
         pause();
      }
   }
   
   /**
      Draws the Spaceship in the current position.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      super.draw(g2);
   }
   
   /**
      Pauses the animation.
   */
   public void pause()
         throws InterruptedException
   {
      component.repaint();
      Thread.sleep(delay);
   }
   /**
    *Returns the coordinate for a condition for when a spaceship is collided into
    *@return the coordinate for a condition for when a spaceship is collided into
    */
   public int getHitBoundary()
   {
   	return getX();
   }
   /**
    *Sets the speed of the spaceship to a given speed
    *@param speed the new speed of the spaceship
    */
   public void setSpeed(int speed)
   {
   	steps = speed;
   	delay = 0;
   }
   
   public static final int NORTH = 1;
   public static final int SOUTH = 2;
   public static final int EAST = 3;
   public static final int WEST = 4;
   
   private int step;
   private int delay;
   private int steps;
   private int direction;
   private JComponent component;
}