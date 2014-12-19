package storyBrickListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import storyBrick.SB_Statement;

public class SpeakerChoiceListener implements ActionListener {

	JComboBox<String> thisCB;
	SB_Statement thisStatement;
	
	public SpeakerChoiceListener(JComboBox<String> setCB, SB_Statement setStatement)
	{
		thisCB = setCB;
		thisStatement = setStatement;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String selection = (String) thisCB.getSelectedItem();
		
		if(selection == "Player")
			thisStatement.speaker = 0;
		else if(selection == "AI")
			thisStatement.speaker = 1;
	}
}
