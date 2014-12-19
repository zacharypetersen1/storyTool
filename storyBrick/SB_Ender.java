package storyBrick;

import graphics.MyPanel;
import infrastructure.Arch;
import infrastructure.TargetStory;

import java.awt.Color;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;

import dataStorage.ColorStore;
import listeners.InListener;
import listeners.MovementInitListener;
import listeners.MyMouseListener;
import listeners.OutListener;

public class SB_Ender extends StoryBrick{
	public SB_Ender(TargetStory target, MyPanel panel)
	{
		super();
		
		targetStory = target;
		
		//set up the main button (used to drag around the storybrick)
		thisButton = new JButton(Arch.end_main);
		thisButton.addMouseListener(new MovementInitListener());
		thisButton.addMouseMotionListener(new MyMouseListener(this));
		
		//set up the other buttons
		in = new JButton("in");
		in.setBackground(ColorStore.defaultGray);
		inListener = new InListener(this);
		in.addActionListener(inListener);
		
		//add the buttons
		panel.add(thisButton);
		panel.add(in);
		
		//run set appearance
		setAppearance();
		
		//run the update to set size and position of buttons
		update();
	}
	
	public void update()
	{
		mainX = x + Arch.globalX;
		mainY = y + Arch.globalY;
		inX = mainX - width/2 - inOutWidth/2;
		inY = mainY;
		thisButton.setLocation(mainX - width/2, mainY - height/2);
		in.setLocation(inX - inOutWidth/2, inY - inOutHeight/2);
		targetStory.arch.panel.repaint();
	}
	
	public void setAppearance()
	{
		super.setAppearance();
		thisButton.setSize(width, height);
		in.setSize(inOutWidth, inOutHeight);
	}
	
	public void make() throws IOException
	{
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(targetStory.outFile, true)));
		writer.println("        if(convStage == " + thisStage + ")");
		writer.println("        {");
		writer.println("        	isConv = false;");
		writer.println("        }");
		writer.println("");
		writer.close();
	}
	
	public void findStage()
	{
		thisStage = targetStory.counter;
		targetStory.counter++;
	}
	
}
