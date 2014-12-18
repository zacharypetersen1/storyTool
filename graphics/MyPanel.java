package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import prototype1.Arch;


//This is the panel class
public class MyPanel extends JLayeredPane {

	//Draw information, tells where to draw the line
	int drawY = 0;
	//Must be able to access the lists containing storybricks
	Arch thisArch;
	
	public MyPanel(Arch setToThis)
	{
		//Set layout of panel to null (so that we use normal cartesian positioning)
		this.setLayout(null);
		thisArch = setToThis;
	}
	
	//Contains drawing code
	public void drawInHere(Graphics g)
	{
		//Create graphics obj that will be used to call drawing code
		Graphics2D g2d = (Graphics2D) g;
		
		//Calls drawing functions within storyBricks
		for(int i = 0; i < thisArch.statementList.size(); i++)
		{
			thisArch.statementList.get(i).drawFlowLines(g2d);
		}
		
		for(int i = 0; i < thisArch.threeSplitList.size(); i++)
		{
			thisArch.threeSplitList.get(i).drawFlowLines(g2d);
		}
		
		for(int i = 0; i < thisArch.starterList.size(); i++)
		{
			thisArch.starterList.get(i).drawFlowLines(g2d);
		}
		
	}
	
	//Overiding the interface method, calls the method with drawing code
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		drawInHere(g);
	}
	
}
