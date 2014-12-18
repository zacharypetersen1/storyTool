package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Just a very basic test template for the button listeners i will be using
public class MyButtonListener implements ActionListener {
	
	//We need access to the drawing info which in this case is stored in MyPanel
	MyPanel panel;
	
	MyButtonListener(MyPanel setToThis)
	{
		//Make sure we have access to the draw information
		panel = setToThis;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//If button is clicked
		//change the draw information
		panel.drawY += 50;
		//redraw the frame
		panel.repaint();
		
	}
}
