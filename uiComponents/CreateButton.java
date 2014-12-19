package uiComponents;

import infrastructure.Arch;

import javax.swing.JButton;

import createListeners.*;
import dataStorage.ColorStore;

public class CreateButton {

	JButton thisButton;
	
	public CreateButton(UI.Type type)
	{
		
		switch(type)
		{
		case Starter : 
			thisButton = new JButton("Starter");
			thisButton.setBackground(ColorStore.startColor);
			thisButton.addActionListener(new CreateStarterListener(Arch.arch));
			thisButton.setLocation(100,600);
						break;
		case Statement :
			thisButton = new JButton("Statement");
			thisButton.setBackground(ColorStore.stmColor);
			thisButton.addActionListener(new CreateStatementListener(Arch.arch));
			thisButton.setLocation(200, 600);
						break;
		case ThreeSplit :
			thisButton = new JButton("ThreeSplit");
			thisButton.setBackground(ColorStore.tsColor);
			thisButton.addActionListener(new CreateThreeSplitListener(Arch.arch));
			thisButton.setLocation(300, 600);
						break;
		case Ender : 
			thisButton = new JButton("Ender");
			thisButton.setBackground(ColorStore.endColor);
			thisButton.addActionListener(new CreateEnderListener(Arch.arch));
			thisButton.setLocation(400, 600);
						break;
		case Make :
			thisButton = new JButton("Make");
			thisButton.addActionListener(new MakeListener(Arch.arch));
			thisButton.setLocation(600, 600);
		}
		
		thisButton.setSize(80,30);
		Arch.arch.panel.add(thisButton);
	}
	
}
