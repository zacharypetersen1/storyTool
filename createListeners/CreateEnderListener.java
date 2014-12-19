package createListeners;

import infrastructure.Arch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
