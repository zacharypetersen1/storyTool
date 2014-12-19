package storyBrickListeners;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import storyBrick.StoryBrick;

public class MovementDragListener extends MouseMotionAdapter {

	StoryBrick thisSB;
	static boolean initDelta;
	static int mouseX, mouseY, prevX, prevY, deltaX, deltaY;
	
	public MovementDragListener(StoryBrick setToThis)
	{
		thisSB = setToThis;
	}
	
	public void mouseDragged(MouseEvent e)
	{
		if(initDelta)
		{
			prevX = MouseInfo.getPointerInfo().getLocation().x;
			prevY = MouseInfo.getPointerInfo().getLocation().y;
			initDelta = false;
		}
		mouseX = MouseInfo.getPointerInfo().getLocation().x;
		mouseY = MouseInfo.getPointerInfo().getLocation().y;
		deltaX = mouseX-prevX;
		deltaY = mouseY-prevY;
		thisSB.x += deltaX;
		thisSB.y += deltaY;
		prevX = mouseX;
		prevY = mouseY;
		thisSB.update();
	}
	
	
	
}
