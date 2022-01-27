/*
 *Cameron Bourque
 *4/4/17
 *Multithreading Lab C
 */
import java.awt.*;
import javax.swing.JComponent;
import java.util.*;

/**
   This component draws a spaceship, 3 ufos, 4 meteors and many planet shapes.
*/
public class SpaceshipComponent extends JComponent
{
   private MovingSpaceship spaceship1;
   private MovingUFO ufo1;
   private MovingUFO ufo2;
   private MovingUFO ufo3;
   private MovingMeteor meteor1;
   private MovingMeteor meteor2;
   private MovingMeteor meteor3;
   private MovingMeteor meteor4;
   private ArrayList<Planet> planets = new ArrayList<Planet>();
   private boolean finished;
   
	/**
	 * Adds spaceships, ufos and meteors to the component
	 */
   public SpaceshipComponent()
   {
   	  int sps = new Random().nextInt(20)+6;
   	  int ufo1s = new Random().nextInt(20)+6;
   	  int ufo2s = new Random().nextInt(20)+6;
   	  int ufo3s = new Random().nextInt(20)+6;
      spaceship1 = new MovingSpaceship(0, 412, sps, 15, (1500)/sps+1, MovingSpaceship.EAST, this);
      ufo1 = new MovingUFO(-900, 100, ufo1s, 15, (1500+900)/ufo1s+1, MovingUFO.EAST, this);
      ufo2 = new MovingUFO(-550, 400, ufo2s, 15, (1500+550)/ufo2s+1, MovingUFO.EAST, this);
      ufo3 = new MovingUFO(-1200, 700, ufo3s, 15, (1500+1200)/ufo3s+1, MovingUFO.EAST, this);
      meteor1 = new MovingMeteor(1600, 200, 25, new Random().nextInt(10)+5, 15, 500, MovingMeteor.WEST,this);
      meteor2 = new MovingMeteor(1550, 500, 40, new Random().nextInt(10)+5, 15, 500, MovingMeteor.WEST,this);
      meteor3 = new MovingMeteor(1700, 800, 15, new Random().nextInt(10)+5, 15, 500, MovingMeteor.WEST,this);
      meteor4 = new MovingMeteor(1650, 300, 33, new Random().nextInt(10)+5, 15, 500, MovingMeteor.WEST,this);
	  for(int i=0; i<200; i++)
	  {
	   	int r = new Random().nextInt(8)+1;
		planets.add(new Planet(new Random().nextInt(1500-(2*r)),new Random().nextInt(900-(2*r)),r));
      }
      finished = false;
   }
   
   /**
    * Draws the spaceships, ufos and meteors on a given graphics field
    *@param g the graphics field
    */
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      
      for(Planet p: planets)
      	p.draw(g2);
      spaceship1.draw(g2);
      ufo1.draw(g2);
      ufo2.draw(g2);
      ufo3.draw(g2);
      meteor1.draw(g2);
      meteor2.draw(g2);
      meteor3.draw(g2);
      meteor4.draw(g2);
   }
   
   /**
      Starts a new animation thread.
   */
   public void startAnimation()
   {
   	  /**
   	   *Creates an object that allows the spaceship to animate itself
   	   */
      class SpaceshipRunnable implements Runnable
      {
      	 /**
      	  *Constructs the object with a given spaceship to animate
      	  *@param spaceship the spaceship to animate
      	  */
         public SpaceshipRunnable(MovingSpaceship spaceship)
         {
            this.spaceship = spaceship;
         }
      	 /**
      	  *Animates the spaceship
      	  */
         public void run()
         {
            try
            {
               spaceship.animate();
            }
            catch (InterruptedException exception)
            {
            }
         }
         private MovingSpaceship spaceship;
      }
      /**
       *Creates an object that allows a ufo to animate itself
       */
      class UFORunnable implements Runnable
      {
      	 /**
      	  *Constructs the object with a given ufo to animate
      	  *@param ufo the ufo to animate
      	  */
      	 public UFORunnable(MovingUFO ufo)
      	 {
      	 	this.ufo = ufo;
      	 }
      	 /**
      	  *Animates the ufo
      	  */
      	 public void run()
         {
            try
            {
               ufo.animate();
            }
            catch (InterruptedException exception)
            {
            }
         }
         private MovingUFO ufo;
      }
      /**
       *Creates an object that allows a meteor to animate itself
       */
      class MeteorRunnable implements Runnable
      {
      	private MovingMeteor meteor;
      	 /**
      	  *Constructs the object with a given meteor to animate
      	  *@param meteor the meteor to animate
      	  */
      	public MeteorRunnable(MovingMeteor meteor)
      	{
      		this.meteor = meteor;
      	}
      	 /**
      	  *Animates the meteor
      	  */
      	public void run()
      	{
      		try
      		{
      			meteor.animate();
      		}
            catch (InterruptedException exception)
            {
            }
      	}
      }
      
	  ArrayList<Runnable> r = new ArrayList<Runnable>();
      r.add(new SpaceshipRunnable(spaceship1));
      r.add(new UFORunnable(ufo1));
      r.add(new UFORunnable(ufo2));
      r.add(new UFORunnable(ufo3));
      r.add(new MeteorRunnable(meteor1));
      r.add(new MeteorRunnable(meteor2));
      r.add(new MeteorRunnable(meteor3));
      r.add(new MeteorRunnable(meteor4));
      ArrayList<Thread> t = new ArrayList<Thread>();
      for(Runnable ru : r)
      	t.add(new Thread(ru));
      for(Thread th : t)
      	th.start();
      boolean done = false;
      while(!done)
      {
      	if(spaceship1.getHitBoundary()<=ufo2.getHitBoundary() && spaceship1.getHitBoundary()<1500)
      	{
      		spaceship1.setSpeed(ufo2.getSpeed()+1500);
      		t.get(0).interrupt();
      		t.get(2).interrupt();
      		Runnable shipRestartR = new SpaceshipRunnable(spaceship1);
      		Thread shipRestart = new Thread(shipRestartR);
      		shipRestart.start();
      		try
      		{
      			Thread.sleep(500);
      		}
            catch (InterruptedException exception)
            {
            }
            Runnable ufoRestartR = new UFORunnable(ufo2);
            Thread ufoRestart = new Thread(ufoRestartR);
            ufoRestart.start();
      	}
      	if(spaceship1.getHitBoundary()>1500)
      		done = true;
      }
      finished = true;
   }
   /**
    *Returns whether the animation is completed
    *@return whether the animation is completed
    */
   public boolean done()
   {
   	return finished;
   }
}