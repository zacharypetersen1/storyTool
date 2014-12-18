package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MovementInitListener extends MouseAdapter {
	
	
	public void mousePressed(MouseEvent e)
	{
		MyMouseListener.initDelta = true;
	}
}
