/*
 *Cameron Bourque
 *4/4/17
 *Multithreading Lab C
 */
import javax.swing.JComponent;
import java.awt.Graphics2D;

/**
 *Creates a moving meteor that allows a meteor to animate
 */
public class MovingMeteor extends Meteor
{
   /**
      Creates a new MovingMeteor Instance
      @param leftX the x coordinate of the top left corner
      @param topY the y coordinate of the top left corner
      @param step Step in pixels the meteor will move each time
      @param delay The delay to wait between each step
      @param steps How many times the meteor will move
      @param direction In which direction the meteor will move
      @param component The component
    */
   public MovingMeteor(int leftX, int topY, int radius, int step, int delay, int steps,
         int direction, JComponent component)
   {
      super(leftX, topY, radius);
      this.step = step;
      this.delay = delay;
      this.steps = steps;
      this.direction = direction;
      this.component = component;
   }
   
   /**
    * Adjusts the Meteor's x and y locations based on the direction it is going.  Moves it a fixed
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
      Draws the Meteor in the current position.
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