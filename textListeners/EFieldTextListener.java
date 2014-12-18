package textListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import storyBrick.StoryBrick;

public class EFieldTextListener implements ActionListener {
	
	EditableField.ValueType thisValueType;
	JTextField thisTextField;
	StoryBrick thisStoryBrick;
	EditableField thisEField;
	
	
	public EFieldTextListener(EditableField.ValueType setValueType, JTextField setTextField, StoryBrick setStoryBrick, EditableField setEField)
	{
		thisValueType = setValueType;
		thisTextField = setTextField;
		thisStoryBrick = setStoryBrick;
		thisEField = setEField;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		//thisFieldType.statement = field.getText();
		
	}
	
}
