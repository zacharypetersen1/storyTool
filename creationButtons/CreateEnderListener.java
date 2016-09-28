package creationButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import infrastructure.Controller;


public class CreateEnderListener implements ActionListener {

	Controller arch;
	
	public CreateEnderListener(Controller setArch)
	{
		arch = setArch;
	}
	
	public void actionPerformed (ActionEvent e)
	{
		arch.addEnder();
	}
	
}
