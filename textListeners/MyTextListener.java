package textListeners;

import infrastructure.Controller;

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
		if(Controller.controller.textQueStatus == -1)
			textField.setText("");
		
		else
		{
			switch(Controller.controller.textQueStatus)
			{
			case(0) :	Controller.controller.textQueClipboard.stm.setBackground(ColorStore.defaultGray);
						Controller.controller.textQueClipboard.setStatement(textField.getText()); break;
			case(1) :	Controller.controller.textQueClipboard.opt1.setBackground(ColorStore.defaultGray);
						Controller.controller.textQueClipboard.setStatement(textField.getText(), 1); break;
			case(2) :	Controller.controller.textQueClipboard.opt2.setBackground(ColorStore.defaultGray);
						Controller.controller.textQueClipboard.setStatement(textField.getText(), 2); break;
			case(3) :	Controller.controller.textQueClipboard.opt3.setBackground(ColorStore.defaultGray);
						Controller.controller.textQueClipboard.setStatement(textField.getText(), 3); break;
			}
			Controller.controller.textQueClipboard.update();
			Controller.controller.textQueClipboard = null;
			Controller.controller.textQueStatus = -1;
			textField.setText("");
		}
	}
}
