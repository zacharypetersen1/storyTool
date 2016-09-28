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
		if(Controller.controller.textQueueStatus == -1)
			textField.setText("");
		
		else
		{
			switch(Controller.controller.textQueueStatus)
			{
			case(0) :	Controller.controller.textQueueClipboard.stm.setBackground(ColorStore.defaultGray);
						Controller.controller.textQueueClipboard.setStatement(textField.getText()); break;
			case(1) :	Controller.controller.textQueueClipboard.opt1.setBackground(ColorStore.defaultGray);
						Controller.controller.textQueueClipboard.setStatement(textField.getText(), 1); break;
			case(2) :	Controller.controller.textQueueClipboard.opt2.setBackground(ColorStore.defaultGray);
						Controller.controller.textQueueClipboard.setStatement(textField.getText(), 2); break;
			case(3) :	Controller.controller.textQueueClipboard.opt3.setBackground(ColorStore.defaultGray);
						Controller.controller.textQueueClipboard.setStatement(textField.getText(), 3); break;
			}
			Controller.controller.textQueueClipboard.update();
			Controller.controller.textQueueClipboard = null;
			Controller.controller.textQueueStatus = -1;
			textField.setText("");
		}
	}
}
