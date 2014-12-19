package storyBrickListeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MovementClickListener extends MouseAdapter {
	
	
	public void mousePressed(MouseEvent e)
	{
		MovementDragListener.initDelta = true;
	}
}
