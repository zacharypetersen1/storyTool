package textListeners;

import javax.swing.JTextField;

import storyBrick.StoryBrick;

public class EditableField {

	public static final int HEIGHT = 20;
	public static final int BUTTON_WIDTH = 20;
	public static final int MIN_TEXT_WIDTH = 20;
	int totalWidth = 80;
	public int x,y;
	boolean isActive = false;
	ValueType thisValueType;
	StoryBrick thisStoryBrick;
	JTextField thisTextField;
	
	//This enum can record what value this EField is effecting
	public enum ValueType
	{
		stm, in, out;
	}
	
	public EditableField(ValueType setValueType, StoryBrick setStoryBrick)
	{
		//Record Variables
		thisValueType = setValueType;
		thisStoryBrick = setStoryBrick;
		
		//Set up text field and listener
		thisTextField = new JTextField();
		//thisTextField.addActionListener(new EFieldTextListener(thisValueType, thisTextField, thisStoryBrick));
		
		//Set up button and listener
	}
	
	public void setTotalWidth(int set)
	{
		if(set < EditableField.BUTTON_WIDTH + EditableField.MIN_TEXT_WIDTH)
			set = EditableField.BUTTON_WIDTH + EditableField.MIN_TEXT_WIDTH;
		totalWidth = set;
	}
	
	public int getTotalWidth()
	{
		return totalWidth;
	}
}
