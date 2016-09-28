package creationButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import infrastructure.Controller;


public class CreateStarterListener implements ActionListener {

	Controller arch;
	
	public CreateStarterListener(Controller setArch)
	{
		arch = setArch;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		arch.addStarter();
	}
}
