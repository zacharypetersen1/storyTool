package createListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import prototype1.Arch;

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
