import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.lang.Math.*;



public class ClockAnimationTester{

 public static void main(String[] args)
   {
 	
	JFrame frame = new JFrame();
	ClockShape shape = new ClockShape(0,0, 100, 0,0,0); 
	
	ShapeIcon icon = new ShapeIcon(shape, 600, 600);
	final JLabel label = new JLabel(icon);
	label.setOpaque(true);
	frame.setLayout(new FlowLayout());
	frame.add(label);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true); 
	final int DELAY = 1000;

	 Timer t = new Timer(DELAY, new     //construct timer t and define its event handler anonymously
       ActionListener()
       {
         public void actionPerformed(ActionEvent event)
         {
         
           shape.translate(1,0); //these parameters are required by the definition of the Moveable interface, 
                                 //but they won't be used. We will devise a special way of "translating" the ball 
           label.repaint(); //with each tick of the timer, we repaint the frame, producing animation.
         }
       });
     t.start(); //start the animation
   }
}