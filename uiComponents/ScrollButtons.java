package uiComponents;

import infrastructure.Controller;

import javax.swing.JButton;

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
		Controller.controller.panel.add(up);
		Controller.controller.panel.add(down);
		Controller.controller.panel.add(left);
		Controller.controller.panel.add(right);
		//add listeners to buttons
		up.addActionListener(new ScrollListener(ScrollListener.direction.up, scrollSpeed));
		down.addActionListener(new ScrollListener(ScrollListener.direction.down, scrollSpeed));
		left.addActionListener(new ScrollListener(ScrollListener.direction.left, scrollSpeed));
		right.addActionListener(new ScrollListener(ScrollListener.direction.right, scrollSpeed));
	}
}