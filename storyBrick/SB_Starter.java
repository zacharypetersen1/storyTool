package storyBrick;

import infrastructure.Controller;
import infrastructure.Story;

import java.awt.Graphics2D;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;

import storyBrickListeners.MovementClickListener;
import storyBrickListeners.MovementDragListener;
import storyBrickListeners.OutListener;
import window.MyPanel;
import dataStorage.ColorStore;

public class SB_Starter extends StoryBrick {

	public SB_Starter(Story target, MyPanel panel)
	{
		super();
		
		targetStory = target;
		
		//set up the main button (used to drag around the storybrick)
		thisButton = new JButton(Controller.start_main);
		thisButton.addMouseListener(new MovementClickListener());
		thisButton.addMouseMotionListener(new MovementDragListener(this));
		thisButton.setBackground(ColorStore.startColor);
		
		//set up the other buttons
		out1 = new JButton("out");
		out1.setBackground(ColorStore.defaultGray);
		out1Listener = new OutListener(this, 1, targetStory.controller);
		out1.addActionListener(out1Listener);
		
		//add the buttons
		panel.add(thisButton);
		panel.add(out1);
		
		//Set the appearance
		setAppearance();
		
		//run the update to set size and position of buttons
		update();
		
		targetStory.controller.starter = this;
	}
	
	public void findStage()
	{
		pointer1.findStage();
	}
	
	public void update()
	{
		//Update position variables in relation to x and y (remember, "x" and "y" have already been updated)
		mainX = x+Controller.globalX;
		mainY = y+Controller.globalY;
		out1X = mainX + width/2 + inOutWidth/2;
		out1Y = mainY;	
		
		//Execute positioning commands (factor in button width b/c java draws from top-left corner of button
		//and we want X/Y positions to be middle of button)
		thisButton.setLocation(mainX-width/2,mainY-height/2);
		out1.setLocation(out1X-inOutWidth/2, out1Y-inOutHeight/2);
		targetStory.controller.panel.repaint();
	}
	
	public void setAppearance()
	{
		//Call parent method to get code that is shared by all storybricks
		super.setAppearance();
		
		//Now execute code specific to "starter" brick
		out1.setSize(20, 20);
	}
	
	public void drawFlowLines(Graphics2D g)
	{
		if(pointer1 == null)
		{
			//if not pointing at anything, do nothing
		}
		else
		{
			//else draw a line from output to the pointer's input
			g.drawLine(out1X, out1Y, pointer1.inX, pointer1.inY);
		}
	}
	
	public void make() throws IOException
	{
		PrintWriter writer = new PrintWriter(new FileWriter(targetStory.outFile, true));
		writer.println("if(not isConv)");
		writer.println("{");
		writer.println("    if(distance_to_object(obj_player) < 100)");
		writer.println("    {");
		writer.println("        convCounter = 0;");
		writer.println("        isConv = true;");
		writer.println("        convInc = 100;");
		writer.println("        convStage = 0;");
		writer.println("        convSegment = 0;");
		writer.println("    }");
		writer.println("}");
		writer.println("");        
		writer.println("else if(isConv)");
		writer.println("{");
		writer.println("");
		writer.close();
		
		pointer1.make();
		
		writer = new PrintWriter(new FileWriter(targetStory.outFile, true));
		writer.println("}");
		writer.close();
		
	}
}
