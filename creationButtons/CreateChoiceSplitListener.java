package creationButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import infrastructure.Controller;


public class CreateChoiceSplitListener implements ActionListener {	
	
	Controller arch;
	
	public CreateChoiceSplitListener(Controller setArch)
	{
		arch = setArch;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		arch.addThreeSplit();
	}
}