package uiComponents;

import infrastructure.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollListener implements ActionListener {

	ScrollListener.direction dir;
	float delta;
	
	public enum direction
	{
		up,down,left,right;
	}
	
	public ScrollListener(ScrollListener.direction d, float setDelta)
	{
		dir = d;
		delta = setDelta;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//first offset the global var
		switch(dir)
		{
		case up : Controller.globalY += delta; break;
		case down : Controller.globalY -= delta; break;
		case left : Controller.globalX += delta; break;
		case right : Controller.globalX -= delta; break;
		}
		
		//then update the ui positions
		Controller.controller.updateAll();
	}
}
