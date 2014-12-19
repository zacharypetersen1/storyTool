package storyBrick;

import infrastructure.Controller;
import infrastructure.Story;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.io.IOException;

import javax.swing.JButton;

import storyBrickListeners.InListener;
import storyBrickListeners.OutListener;

public class StoryBrick {
	
	//Variables
	Story targetStory;
	StoryBrick pointer1, pointer2, pointer3;
	int thisStage, targetStage1, targetStage2, targetStage3;
	int timeLimit = 60;
	
	//Display Var's
	public int x = 50, y = 50;
	int width = 64, height = 32, inOutWidth = 20, inOutHeight = 20;
	int mainX, mainY, inX, inY, out1X, out1Y, out2X, out2Y, out3X, out3Y;
	public Point mousePoint;
	public JButton thisButton, in, out1, out2, out3;
	
	public JButton stm;	//used in SB_statement only!
	public JButton opt1, opt2, opt3; //used in SB_ThreeSplit only!
	
	InListener inListener;
	OutListener out1Listener, out2Listener, out3Listener;
	
	//Constructors
	public StoryBrick()
	{
		x = 50 - Controller.globalX;
		y = 50 - Controller.globalY;
	}
	
	//Methods
	public void setPointer(int pointerNum, StoryBrick setPointer)
	{
		switch (pointerNum)
		{
		case (1) : pointer1 = setPointer; break;
		case (2) : pointer2 = setPointer; break;
		case (3) : pointer3 = setPointer; break;
		}
	}
	
	public void setTimeLimit(int setToThis)
	{
		timeLimit = setToThis;
	}
	
	public void make() throws IOException
	{
		System.out.println("using main");
	}
	
	
	//Contains appearence initialization code that is shared by all children of "StoryTool"
	public void setAppearance()
	{
		thisButton.setBackground(new Color(0,0,0,0));
		thisButton.setBorder(null);
		thisButton.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		thisButton.setSize(width, height);
		
	}
	
	public void findStage()
	{	
	}
	
	public void update()
	{
		
	}

	//setStatement methods that will be overwritten by child obj's
	//For now, just here on testing purposes
	public void setStatement()
	{	
	}
	public void setStatement(String setToThis)
	{	
	}
	public void setStatement(String setToThis1, String setToThis2, String setToThis3)
	{
	}
	public void setStatement(String setToThis, int optionNum)
	{
	}
	public void setStatement(int optionNum)
	{
	}
	
}
