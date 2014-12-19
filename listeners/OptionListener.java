package listeners;

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
		if(Controller.controller.textQueClipboard == thisThreeSplit && Controller.controller.textQueStatus == optionNum)
		{
			thisButton.setBackground(ColorStore.defaultGray);
			UI.ui.textField.setText("");
			Controller.controller.textQueClipboard = null;
			Controller.controller.textQueStatus = -1;
		}
		else
		{
			//check if something else is selected
			switch(Controller.controller.textQueStatus)
			{
			//reset the other object so that it is no longer selected
			case(0) : Controller.controller.textQueClipboard.stm.setBackground(ColorStore.defaultGray); break;
			case(1) : Controller.controller.textQueClipboard.opt1.setBackground(ColorStore.defaultGray); break;
			case(2) : Controller.controller.textQueClipboard.opt2.setBackground(ColorStore.defaultGray); break;
			case(3) : Controller.controller.textQueClipboard.opt3.setBackground(ColorStore.defaultGray); break;
			}
		
			Controller.controller.textQueStatus = optionNum;
			Controller.controller.textQueClipboard = thisThreeSplit;
			thisButton.setBackground(ColorStore.selectColor);
			Controller.controller.ui.textField.setText(thisThreeSplit.getOption(optionNum));
			thisThreeSplit.update();
		}
	}
	
}
