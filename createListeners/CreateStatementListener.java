package createListeners;

import infrastructure.Arch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.Color;

public class CreateStatementListener implements ActionListener {	
	
	Arch arch;
	
	public CreateStatementListener(Arch setArch)
	{
		arch = setArch;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		arch.addStatement();
	}
}
