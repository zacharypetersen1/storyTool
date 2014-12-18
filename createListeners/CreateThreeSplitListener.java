package createListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import prototype1.Arch;


public class CreateThreeSplitListener implements ActionListener {	
	
	Arch arch;
	
	public CreateThreeSplitListener(Arch setArch)
	{
		arch = setArch;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		arch.addThreeSplit();
	}
}