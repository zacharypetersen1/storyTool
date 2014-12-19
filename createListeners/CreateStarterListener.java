package createListeners;

import infrastructure.Arch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateStarterListener implements ActionListener {

	Arch arch;
	
	public CreateStarterListener(Arch setArch)
	{
		arch = setArch;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		arch.addStarter();
	}
}
