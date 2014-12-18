package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dataStorage.ColorStore;
import prototype1.Arch;
import storyBrick.SB_ThreeSplit;
import uiComponents.UI;

public class OptionListener implements ActionListener {

	SB_ThreeSplit thisThreeSplit;
	int optionNum;
	JButton thisButton;
	
	
	public OptionListener(SB_ThreeSplit setToThis, int setNum, JButton setButton)
	{
		thisThreeSplit = setToThis;
		optionNum = setNum;
		thisButton = setButton;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(Arch.arch.textQueClipboard == thisThreeSplit && Arch.arch.textQueStatus == optionNum)
		{
			thisButton.setBackground(ColorStore.defaultGray);
			UI.ui.textField.setText("");
			Arch.arch.textQueClipboard = null;
			Arch.arch.textQueStatus = -1;
		}
		else
		{
			//check if something else is selected
			switch(Arch.arch.textQueStatus)
			{
			//reset the other object so that it is no longer selected
			case(0) : Arch.arch.textQueClipboard.stm.setBackground(ColorStore.defaultGray); break;
			case(1) : Arch.arch.textQueClipboard.opt1.setBackground(ColorStore.defaultGray); break;
			case(2) : Arch.arch.textQueClipboard.opt2.setBackground(ColorStore.defaultGray); break;
			case(3) : Arch.arch.textQueClipboard.opt3.setBackground(ColorStore.defaultGray); break;
			}
		
			Arch.arch.textQueStatus = optionNum;
			Arch.arch.textQueClipboard = thisThreeSplit;
			thisButton.setBackground(ColorStore.selectColor);
			Arch.arch.ui.textField.setText(thisThreeSplit.getOption(optionNum));
			thisThreeSplit.update();
		}
	}
	
}
