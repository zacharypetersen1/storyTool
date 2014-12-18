package prototype1;


import graphics.MyFrame;
import graphics.MyPanel;
import importedClasses.AlphaImageIcon;

import java.awt.Color;
import java.util.*;

import javax.swing.*;

import createListeners.CreateEnderListener;
import createListeners.CreateStarterListener;
import createListeners.CreateStatementListener;
import createListeners.CreateThreeSplitListener;
import createListeners.MakeListener;
import storyBrick.SB_Ender;
import storyBrick.SB_Starter;
import storyBrick.SB_Statement;
import storyBrick.SB_ThreeSplit;
import storyBrick.StoryBrick;
import textListeners.MyTextListener;
import uiComponents.UI;

public class Arch {
	
	public static Arch arch;	//Making a global var to store our arch allows us to access arch anywhere
	public static int globalX, globalY;	//records global offset
	
	TargetStory story;	//allows us to reference our story class
	MyFrame frame;		//will be created when arch is initialized
	public MyPanel panel;	//will be created when arch is initialized, also is referenced by other classes
	public UI ui;
	
	//All of the following lists store the SB objects and their corresponding buttons that exist in the editor		!!!NOTE:if have time, rewrite this code so that the "main" buttons are stored within each SB rather than here in Arch
	int statementCount=0, threeSplitCount = 0, starterCount = 0, enderCount = 0;	//these ints keep track amount of each type of SB
	public List<SB_Statement> statementList = new ArrayList<SB_Statement>();
	public List<SB_ThreeSplit> threeSplitList = new ArrayList<SB_ThreeSplit>();
	public List<SB_Starter> starterList = new ArrayList<SB_Starter>();
	public List<SB_Ender> enderList = new ArrayList<SB_Ender>();
	
	
	public StoryBrick inOutClipboard;	//stores an SB when clicking to set input/output for SB's
	public SB_Starter starter;

	//Variables for communication between text field and SB's
	public StoryBrick textQueClipboard;	//stores the SB that is selected
	public int textQueStatus = -1;	//records status of text que
		//-1 means nothing selected
		// 0 means SB_statement's statement is selected
		// 1 means SB_threeSplit's option 1 is selected
		// 2 means SB_threeSplit's option 2 is selected
		// 3 means SB_threeSplit's option 3 is selected
	
	public static ImageIcon statement_main, split_main, start_main, end_main;
	JLabel testLabel;
	
	public Arch(TargetStory setStory)
	{
		//Set up Arch
		Arch.arch = this;
		story = setStory;
    	
		//Set up frame and panel
		frame = new MyFrame(story.fileName);
    	panel = new MyPanel(this);
    	frame.add(panel);
    	frame.setSize(2000, 1000);
    	
    	//Access images stored in "images" file:
    	Arch.statement_main = new ImageIcon("C:\\Users\\Zachary\\Documents\\my_eclipse_workspace\\storyTool_Ptyp1\\src\\images\\statement_main.png");
    	Arch.split_main = new ImageIcon("C:\\Users\\Zachary\\Documents\\my_eclipse_workspace\\storyTool_Ptyp1\\src\\images\\split_main.png");
    	Arch.start_main = new ImageIcon("C:\\Users\\Zachary\\Documents\\my_eclipse_workspace\\storyTool_Ptyp1\\src\\images\\start_main.png");
    	Arch.end_main = new ImageIcon("C:\\Users\\Zachary\\Documents\\my_eclipse_workspace\\storyTool_Ptyp1\\src\\images\\end_main.png");
    	
    	//Initialize UI
    	ui = new UI();
    	ui.initialize();
    	
    	//Make frame visible
    	frame.setVisible(true);	
	}


public void addStatement()
{	
	statementList.add(new SB_Statement(story, panel));
	statementCount++;
}

public void addThreeSplit()
{	
	threeSplitList.add(new SB_ThreeSplit(story, panel));
	threeSplitCount++;
}

public void addStarter()
{	
	starterList.add(new SB_Starter(story, panel));
	starterCount++;
}

public void addEnder()
{
	enderList.add(new SB_Ender(story, panel));
	enderCount++;
}

public void updateAll()
{
	for(int i = 0; i < starterCount; i++)
		starterList.get(i).update();

	for(int i = 0; i < statementCount; i++)
		statementList.get(i).update();

	for(int i = 0; i < threeSplitCount; i++)
		threeSplitList.get(i).update();

	for(int i = 0; i < enderCount; i++)
		enderList.get(i).update();
}


}