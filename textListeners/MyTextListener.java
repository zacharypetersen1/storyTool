package textListeners;

import infrastructure.Arch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import dataStorage.ColorStore;

public class MyTextListener implements ActionListener {

	JTextField textField;
	
	public MyTextListener(JTextField setField)
	{
		textField = setField;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(Arch.arch.textQueStatus == -1)
			textField.setText("");
		
		else
		{
			switch(Arch.arch.textQueStatus)
			{
			case(0) :	Arch.arch.textQueClipboard.stm.setBackground(ColorStore.defaultGray);
						Arch.arch.textQueClipboard.setStatement(textField.getText()); break;
			case(1) :	Arch.arch.textQueClipboard.opt1.setBackground(ColorStore.defaultGray);
						Arch.arch.textQueClipboard.setStatement(textField.getText(), 1); break;
			case(2) :	Arch.arch.textQueClipboard.opt2.setBackground(ColorStore.defaultGray);
						Arch.arch.textQueClipboard.setStatement(textField.getText(), 2); break;
			case(3) :	Arch.arch.textQueClipboard.opt3.setBackground(ColorStore.defaultGray);
						Arch.arch.textQueClipboard.setStatement(textField.getText(), 3); break;
			}
			Arch.arch.textQueClipboard.update();
			Arch.arch.textQueClipboard = null;
			Arch.arch.textQueStatus = -1;
			textField.setText("");
		}
	}
}
