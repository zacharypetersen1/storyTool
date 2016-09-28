package uiComponents;

import infrastructure.Controller;

import javax.swing.JButton;
import javax.swing.JTextField;





import creationButtons.CreateButton;
import dataStorage.ColorStore;
import textListeners.MyTextListener;

public class UI {
	
	public static UI ui;
	CreateButton crStarter, crStatement, crThreeSplit, crEnder, crMake, crSave;
	public JTextField textField;	//text field at bottom of editor
	JButton make, save;
	ScrollButtons fast, slow;
	
	public enum Type{
		Starter, Statement, ThreeSplit, Ender, Make, Save
	}
	
	public UI()
	{
		UI.ui = this;
	}
	
	
	public void initialize()
	{

    	//Set up the "create" buttons
		crStarter = new CreateButton(Type.Starter);
		crStatement = new CreateButton(Type.Statement);
		crThreeSplit = new CreateButton(Type.ThreeSplit);
		crEnder = new CreateButton(Type.Ender);
    	crMake = new CreateButton(Type.Make);
    	crSave = new CreateButton(Type.Save);
    	
    	//Create and add text field
    	textField = new JTextField(20);
    	textField.setSize(400, 24);
    	textField.setLocation(100,635);
    	textField.setBackground(ColorStore.defaultGray);
    	Controller.controller.panel.add(textField);
    	//also add specific listener for the text field
    	textField.addActionListener(new MyTextListener(textField));
    	
    	fast = new ScrollButtons(830,600,300,25,"Fast");
    	slow = new ScrollButtons(1120,600,50,25,"Slow");
	}
}
