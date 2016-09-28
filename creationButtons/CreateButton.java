package creationButtons;

import javax.swing.JButton;

import infrastructure.Controller;
import uiComponents.UI;
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
			thisButton.addActionListener(new CreateStarterListener(Controller.controller));
			thisButton.setLocation(100,600);
						break;
		case Statement :
			thisButton = new JButton("Statement");
			thisButton.setBackground(ColorStore.statementColor);
			thisButton.addActionListener(new CreateStatementListener(Controller.controller));
			thisButton.setLocation(200, 600);
						break;
		case ThreeSplit :
			thisButton = new JButton("ThreeSplit");
			thisButton.setBackground(ColorStore.choiceSplitColor);
			thisButton.addActionListener(new CreateChoiceSplitListener(Controller.controller));
			thisButton.setLocation(300, 600);
						break;
		case Ender : 
			thisButton = new JButton("Ender");
			thisButton.setBackground(ColorStore.endColor);
			thisButton.addActionListener(new CreateEnderListener(Controller.controller));
			thisButton.setLocation(400, 600);
						break;
		case Make :
			thisButton = new JButton("Make");
			thisButton.addActionListener(new MakeListener());
			thisButton.setLocation(550, 600);
						break;
		case Save :
			thisButton = new JButton("Save");
			thisButton.addActionListener(new SaveListener());
			thisButton.setLocation(650, 600);
						break;
		}
		
		thisButton.setSize(80,30);
		Controller.controller.panel.add(thisButton);
	}
	
}
