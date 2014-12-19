package uiComponents;

import infrastructure.Arch;

import javax.swing.JButton;

import listeners.ScrollListener;
import dataStorage.ColorStore;

public class ScrollButtons {

	String name;
	int x,y, scrollSpeed, buttonSize;
	JButton up,down,left,right;
	
	public ScrollButtons(int setX, int setY, int setScrollSpeed, int setButtonSize, String setName)
	{
		x = setX;
		y = setY;
		scrollSpeed = setScrollSpeed;
		buttonSize = setButtonSize;
		name = setName;
		
		init();
	}
	
	public void init()
	{
		//Create the buttons
		up = new JButton("^");
		down = new JButton("v");
		left = new JButton("<");
		right = new JButton(">");
		//set button sizes
		up.setSize(buttonSize*2,buttonSize*2);
		down.setSize(buttonSize*2,buttonSize*2);
		left.setSize(buttonSize*2,buttonSize*2);
		right.setSize(buttonSize*2,buttonSize*2);
		//set button locations
		up.setLocation(x,y-buttonSize*3);
		down.setLocation(x,y);
		left.setLocation(x-buttonSize*3,y);
		right.setLocation(x+buttonSize*3,y);
		//set buttons to default color
		up.setBackground(ColorStore.defaultGray);
		down.setBackground(ColorStore.defaultGray);
		left.setBackground(ColorStore.defaultGray);
		right.setBackground(ColorStore.defaultGray);
		//add buttons to panel
		Arch.arch.panel.add(up);
		Arch.arch.panel.add(down);
		Arch.arch.panel.add(left);
		Arch.arch.panel.add(right);
		//add listeners to buttons
		up.addActionListener(new ScrollListener(ScrollListener.direction.up, scrollSpeed));
		down.addActionListener(new ScrollListener(ScrollListener.direction.down, scrollSpeed));
		left.addActionListener(new ScrollListener(ScrollListener.direction.left, scrollSpeed));
		right.addActionListener(new ScrollListener(ScrollListener.direction.right, scrollSpeed));
	}
}