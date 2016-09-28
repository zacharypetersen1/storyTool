package storyBrickListeners;

import infrastructure.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dataStorage.ColorStore;
import storyBrick.SB_Statement;
import uiComponents.UI;

public class StatementListen implements ActionListener {	
	
	SB_Statement thisSBStatement;
	
	public StatementListen(SB_Statement setToThis)
	{
		thisSBStatement = setToThis;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(Controller.controller.textQueueClipboard == thisSBStatement)
		{
			thisSBStatement.stm.setBackground(ColorStore.defaultGray);
			UI.ui.textField.setText("");
			Controller.controller.textQueueClipboard = null;
			Controller.controller.textQueueStatus = -1;
		}
		else
		{
			//check if something else is selected
			switch(Controller.controller.textQueueStatus)
			{
			//reset the other object so that it is no longer selected
			case(0) : Controller.controller.textQueueClipboard.stm.setBackground(ColorStore.defaultGray); break;
			case(1) : Controller.controller.textQueueClipboard.opt1.setBackground(ColorStore.defaultGray); break;
			case(2) : Controller.controller.textQueueClipboard.opt2.setBackground(ColorStore.defaultGray); break;
			case(3) : Controller.controller.textQueueClipboard.opt3.setBackground(ColorStore.defaultGray); break;
			}
		
			//make this statement become selected
			thisSBStatement.stm.setBackground(ColorStore.selectColor);
			Controller.controller.textQueueStatus = 0;
			Controller.controller.textQueueClipboard = thisSBStatement;
			Controller.controller.ui.textField.setText(thisSBStatement.statement);
			thisSBStatement.update();
		}
	}
}