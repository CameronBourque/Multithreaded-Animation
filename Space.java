/*
 *Cameron Bourque
 *4/4/17
 *Multithreading Lab C
 */
import javax.swing.JFrame;
import java.awt.*;
import java.util.*;
/**
 *Creates a frame with a component to animate objects
 */
public class Space
{
	/**
	 *Constructs the frame and starts the animation
	 *@param args arguments provided
	 */
   public static void main(String[] args)
   {
    	JFrame frame = new JFrame();

	    final int FRAME_WIDTH = 1500;
		final int FRAME_HEIGHT = 900;

	    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	    frame.setTitle("Space Chase");
  		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);
		
     	SpaceshipComponent spaceships = new SpaceshipComponent();
     	frame.add(spaceships);

   		frame.setVisible(true);
	    spaceships.startAnimation();
	    
   }
}