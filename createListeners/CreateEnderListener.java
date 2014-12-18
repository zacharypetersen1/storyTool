package createListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import prototype1.Arch;

public class CreateEnderListener implements ActionListener {

	Arch arch;
	
	public CreateEnderListener(Arch setArch)
	{
		arch = setArch;
	}
	
	public void actionPerformed (ActionEvent e)
	{
		arch.addEnder();
	}
	
}
