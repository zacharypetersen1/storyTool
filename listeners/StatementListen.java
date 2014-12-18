package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import dataStorage.ColorStore;
import prototype1.Arch;
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
		if(Arch.arch.textQueClipboard == thisSBStatement)
		{
			thisSBStatement.stm.setBackground(ColorStore.defaultGray);
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
		
			//make this statement become selected
			thisSBStatement.stm.setBackground(ColorStore.selectColor);
			Arch.arch.textQueStatus = 0;
			Arch.arch.textQueClipboard = thisSBStatement;
			Arch.arch.ui.textField.setText(thisSBStatement.statement);
			thisSBStatement.update();
		}
	}
}