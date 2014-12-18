package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import prototype1.Arch;

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
		case up : Arch.globalY += delta; break;
		case down : Arch.globalY -= delta; break;
		case left : Arch.globalX += delta; break;
		case right : Arch.globalX -= delta; break;
		}
		
		//then update the ui positions
		Arch.arch.updateAll();
	}
}
