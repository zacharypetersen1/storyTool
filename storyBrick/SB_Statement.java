package storyBrick;

import infrastructure.Controller;
import infrastructure.Story;

import java.awt.Graphics2D;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;

import storyBrickListeners.InListener;
import storyBrickListeners.MovementClickListener;
import storyBrickListeners.MovementDragListener;
import storyBrickListeners.OutListener;
import storyBrickListeners.SpeakerChoiceListener;
import storyBrickListeners.StatementListen;
import window.MyPanel;
import dataStorage.ColorStore;

public class SB_Statement extends StoryBrick {
	
	//Variables
	public String statement = "text";
	int stmX, stmY;
	int spkrBoxX, spkrBoxY;
	StatementListen stmListen;
	//used to record which character is making this statment
	public int speaker = 0; //0=Player, 1=AI
	//Size variables
	int stmWidth = 200, stmHeight = 24;
	int spkrBoxWidth = width, spkrBoxHeight = 25;
	
	JComboBox<String> speakerOption;
	String[] speakerOptionList = {"Player", "AI"};
	
	//Constructor
	public SB_Statement(Story target, MyPanel panel)
	{
		super();
		
		targetStory = target;
		
		//set up the main button (used to drag around the storybrick)
		thisButton = new JButton(Controller.controller.statement_main);
		thisButton.addMouseListener(new MovementClickListener());
		thisButton.addMouseMotionListener(new MovementDragListener(this));
		
		//set up "in" node button and listener
		in = new JButton("in");
		inListener = new InListener(this);
		in.addActionListener(inListener);
		
		//set up "out" node button and listener
		out1 = new JButton("out");
		out1Listener = new OutListener(this, 1, targetStory.controller);
		out1.addActionListener(out1Listener);
		
		//set up "statement" button and listener
		//this is the button that is used to change the statement when clicked
		stm = new JButton(statement);
		stmListen = new StatementListen(this);
		stm.addActionListener(stmListen);
		
		//add the buttons
		panel.add(thisButton);
		panel.add(in);
		panel.add(out1);
		panel.add(stm);
		
		//set up the combo box
		speakerOption = new JComboBox<String>(speakerOptionList);
		SpeakerChoiceListener scl = new SpeakerChoiceListener(speakerOption, this);
		speakerOption.addActionListener(scl);
		panel.add(speakerOption);
		
		
		//set up the appearance of the SB
		setAppearance();
		//run the update to set size and position of buttons
		update();
	}
	
	//Methods
	public void setStatement(String setToThis)
	{
		statement = setToThis;
	}
	
	public void findStage()
	{
		thisStage = targetStory.counter;
		targetStory.counter++;
		targetStage1 = targetStory.counter;
		pointer1.findStage();
	}
	
	//This method updates the positions of all of the components
	//	associated with this statement then calls a method that
	//	repaints the flowchart lines (betw "in" and "out" nodes)
	public void update()
	{
		//Update secondary position variables (remember, "x" and "y"
		// have already been updated)
		mainX = x+Controller.globalX;
		mainY = y+Controller.globalY;
		inX = mainX - width/2 - inOutWidth/2;
		inY = mainY;
		out1X = mainX + width/2 + inOutWidth/2;
		out1Y = mainY;
		stmX = mainX;
		stmY = mainY-height/2-stmHeight/2;	//The 10 is how mush offset over the main button
		spkrBoxX = mainX;
		spkrBoxY = mainY + height/2 + spkrBoxHeight/2;
		
		//Update the locations of all components
		thisButton.setLocation(mainX-width/2,mainY-height/2);
		stm.setLocation(stmX-stmWidth/2,stmY-stmHeight/2);
		in.setLocation(inX-inOutWidth/2,inY-inOutHeight/2);
		out1.setLocation(out1X-inOutWidth/2, out1Y-inOutHeight/2);
		speakerOption.setLocation(spkrBoxX-spkrBoxWidth/2, spkrBoxY-spkrBoxHeight/2);
		
		//Update the string inside "statement" button
		stm.setText(statement);
		
		//Repaint the flowchart lines
		targetStory.controller.panel.repaint();
	}
	
	//This method sets the colors and sizes of the various
	//	components associated with this statement
	public void setAppearance()
	{
		/***General*****/
		//Buttons
		//thisButton.setBackground(new Color(0,0,0,0));
		//thisButton.setBorder(null);
		//thisButton.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		//in.setBackground(ColorStore.defaultGray);
		
		super.setAppearance();
		
		in.setBackground(ColorStore.defaultGray);
		out1.setBackground(ColorStore.defaultGray);
		stm.setBackground(ColorStore.defaultGray);
		//ComboBoxes
		speakerOption.setBackground(new Color(100,100,100));
		speakerOption.setForeground(new Color(200,200,200));
		
		/***Sizes****/
		//Buttons
		stm.setSize(stmWidth,stmHeight);
		in.setSize(inOutWidth,inOutHeight);
		out1.setSize(inOutWidth, inOutHeight);
		//ComboBoxes
		speakerOption.setSize(spkrBoxWidth, spkrBoxHeight);
	}
	
	//This method will draw a line from the output node of
	// this statement to the input node of whatever storybrick
	// this statement is pointing at
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
	
	
	
	//Outputs code into the output file that will execute this
	// statement when output code is run on external game engine
	public void make() throws IOException
	{
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(targetStory.outFile, true)));
		writer.println("        if(convStage == " + thisStage + ")");
		writer.println("        {");
		if(speaker == 0)
		{
		writer.println("            with(obj_player)");
		}
		else if(speaker == 1)
		{
		writer.println("            with(obj_pirateA)");	
		}
		writer.println("            {");
		writer.println("                graphic_drawText(\"" + statement + "\");");
		writer.println("            }");
		writer.println("            convCounter++;");
		writer.println("            if(convCounter >= " + timeLimit + ")");
		writer.println("        	{");
		writer.println("                convStage = " + targetStage1 + ";");
		writer.println("                convCounter = 0;");
		writer.println("        	}");
		writer.println("        }");
		writer.println("");
		writer.close();
		
		pointer1.make();
	}
	
}
