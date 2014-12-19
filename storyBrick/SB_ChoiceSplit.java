package storyBrick;

import infrastructure.Controller;
import infrastructure.Story;

import java.awt.Graphics2D;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;

import storyBrickListeners.InListener;
import storyBrickListeners.MovementClickListener;
import storyBrickListeners.MovementDragListener;
import storyBrickListeners.OptionListener;
import storyBrickListeners.OutListener;
import window.MyPanel;
import dataStorage.ColorStore;

public class SB_ChoiceSplit extends StoryBrick{

	//Variables
	public String option1 = "option1", option2 = "option2", option3 = "option3";
	OptionListener optListen1, optListen2, optListen3;
	int optWidth = 100, optHeight = 24;
	int opt1X, opt1Y, opt2X, opt2Y, opt3X, opt3Y;
	
	//Constructor
	public SB_ChoiceSplit(Story target, MyPanel panel)
	{
		super();
		
		targetStory = target;
		
		//set up the main button (used to drag around the storybrick)
		thisButton = new JButton(Controller.split_main);
		thisButton.addMouseListener(new MovementClickListener());
		thisButton.addMouseMotionListener(new MovementDragListener(this));
		
		//set up the other buttons
		in = new JButton("in");
		inListener = new InListener(this);
		in.addActionListener(inListener);
		out1 = new JButton("out1");
		out2 = new JButton("out2");
		out3 = new JButton("out3");
		out1Listener = new OutListener(this, 1, targetStory.controller);
		out2Listener = new OutListener(this, 2, targetStory.controller);
		out3Listener = new OutListener(this, 3, targetStory.controller);
		out1.addActionListener(out1Listener);
		out2.addActionListener(out2Listener);
		out3.addActionListener(out3Listener);
		opt1 = new JButton(option1);
		opt2 = new JButton(option2);
		opt3 = new JButton(option3);
		optListen1 = new OptionListener(this, 1, opt1);
		optListen2 = new OptionListener(this, 2, opt2);
		optListen3 = new OptionListener(this, 3, opt3);
		opt1.addActionListener(optListen1);
		opt2.addActionListener(optListen2);
		opt3.addActionListener(optListen3);
		
		//add the buttons
		panel.add(thisButton);
		panel.add(in);
		panel.add(out1);
		panel.add(out2);
		panel.add(out3);
		panel.add(opt1);
		panel.add(opt2);
		panel.add(opt3);
		
		//set up the appearance of this split
		setAppearance();
		
		//run the update to set size and position of buttons
		update();
	}
	
	//Methods
	public void setStatement(String setToThis1, String setToThis2, String setToThis3)
	{
		option1 = setToThis1;
		option2 = setToThis2;
		option3 = setToThis3;
	}
	
	public void setStatement(String setToThis, int optionNum)
	{
		switch(optionNum)
		{
		case (1) : option1 = setToThis; break;
		case (2) : option2 = setToThis; break;
		case (3) : option3 = setToThis; break;
		}
	}
	
	//allows us to quickly access the options
	public String getOption(int optionNum)
	{
		switch(optionNum)
		{
		case(1) : return option1;
		case(2) : return option2;
		case(3) : return option3;
		default : return "getOptionCallError";
		}
		
	}
	
	public void findStage()
	{
		thisStage = targetStory.counter;
		
		targetStory.counter++;
		targetStage1 = targetStory.counter;
		pointer1.findStage();
		
		targetStory.counter++;
		targetStage2 = targetStory.counter;
		pointer2.findStage();
		
		targetStory.counter++;
		targetStage3 = targetStory.counter;
		pointer3.findStage();
	}
	
	public void update()
	{
		mainX = x+Controller.globalX;
		mainY = y+Controller.globalY;
		inX = mainX - width/2 - inOutWidth/2;
		inY = mainY;
		//Find position for "out" buttons
		out1X = mainX + width/2 + inOutWidth/2 + optWidth;
		out1Y = mainY-optHeight;
		out2X = out1X;
		out2Y = inY;
		out3X = out2X;
		out3Y = inY+optHeight;
		//Find positions for "opt" or "option" buttons
		opt1X = mainX + width/2 + optWidth/2;
		opt1Y = out1Y;
		opt2X = opt1X;
		opt2Y = out2Y;
		opt3X = opt2X;
		opt3Y = out3Y;
		
		//Set buttons to correct places
		thisButton.setLocation(mainX-width/2,mainY-height/2);
		opt1.setLocation(opt1X - optWidth/2, opt1Y - optHeight/2);
		opt2.setLocation(opt2X - optWidth/2, opt2Y - optHeight/2);
		opt3.setLocation(opt3X - optWidth/2, opt3Y - optHeight/2);
		opt1.setText(option1);
		opt2.setText(option2);
		opt3.setText(option3);
		in.setLocation(inX-inOutWidth/2,inY-inOutHeight/2);
		out1.setLocation(out1X-inOutWidth/2, out1Y-inOutHeight/2);
		out2.setLocation(out2X-inOutWidth/2, out2Y-inOutHeight/2);
		out3.setLocation(out3X-inOutWidth/2, out3Y-inOutHeight/2);

		
		targetStory.controller.panel.repaint();
	}
	
	public void setAppearance()
	{

		super.setAppearance();


		out1.setBackground(ColorStore.defaultGray);
		out2.setBackground(ColorStore.defaultGray);
		out3.setBackground(ColorStore.defaultGray);
		in.setBackground(ColorStore.defaultGray);
		opt1.setBackground(ColorStore.defaultGray);
		opt2.setBackground(ColorStore.defaultGray);
		opt3.setBackground(ColorStore.defaultGray);
		
		thisButton.setSize(width, height);
		in.setSize(inOutWidth,inOutHeight);
		out1.setSize(inOutWidth, inOutHeight);
		out2.setSize(inOutWidth, inOutHeight);
		out3.setSize(inOutWidth, inOutHeight);
		opt1.setSize(optWidth, optHeight);
		opt2.setSize(optWidth, optHeight);
		opt3.setSize(optWidth, optHeight);
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
		
		if(pointer2 == null)
		{
			//if not pointing at anything, do nothing
		}
		else
		{
			//else draw a line from output to the pointer's input
			g.drawLine(out2X, out2Y, pointer2.inX, pointer2.inY);
		}
		
		if(pointer3 == null)
		{
			//if not pointing at anything, do nothing
		}
		else
		{
			//else draw a line from output to the pointer's input
			g.drawLine(out3X, out3Y, pointer3.inX, pointer3.inY);
		}
	}
	
	public void make() throws IOException
	{	
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(targetStory.outFile, true)));
		writer.println("        if(convStage == "+ thisStage + ")");
		writer.println("        {");
		writer.println("            with(obj_player)");
		writer.println("            {");
		writer.println("                graphic_drawChoice(\"" + option1 +"\", \"" + option2 + "\", \"" + option3 + "\");");
		writer.println("            }");
		writer.println("            if(keyboard_check_pressed(vk_up))");
		writer.println("                convStage = " + targetStage1 + ";");
		writer.println("            if(keyboard_check_pressed(vk_left))");
		writer.println("                convStage = " + targetStage2 + ";");
		writer.println("            if(keyboard_check_pressed(vk_right))");
		writer.println("                convStage = " + targetStage3 + ";");
		writer.println("        }");
		writer.println("");
		writer.close();
		
		pointer1.make();
		
		pointer2.make();
		
		pointer3.make();
	}
}
