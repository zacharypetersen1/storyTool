package storyBrickListeners;

import infrastructure.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dataStorage.ColorStore;
import storyBrick.SB_ChoiceSplit;
import uiComponents.UI;

public class OptionListener implements ActionListener {

	SB_ChoiceSplit thisThreeSplit;
	int optionNum;
	JButton thisButton;
	
	
	public OptionListener(SB_ChoiceSplit setToThis, int setNum, JButton setButton)
	{
		thisThreeSplit = setToThis;
		optionNum = setNum;
		thisButton = setButton;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(Controller.controller.textQueueClipboard == thisThreeSplit && Controller.controller.textQueueStatus == optionNum)
		{
			thisButton.setBackground(ColorStore.defaultGray);
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
		
			Controller.controller.textQueueStatus = optionNum;
			Controller.controller.textQueueClipboard = thisThreeSplit;
			thisButton.setBackground(ColorStore.selectColor);
			Controller.controller.ui.textField.setText(thisThreeSplit.getOption(optionNum));
			thisThreeSplit.update();
		}
	}
	
}
