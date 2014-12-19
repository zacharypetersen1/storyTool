package listeners;

import infrastructure.Arch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dataStorage.ColorStore;
import storyBrick.StoryBrick;

public class InListener implements ActionListener {
	//We need access the SB associated with this button

	StoryBrick thisStoryBrick;
	
	public InListener(StoryBrick setStoryBrick)
	{
		//Set the instance variables
		thisStoryBrick = setStoryBrick;
	}
	
	//actionPerformed is called when user clicks on this "in" button
	public void actionPerformed(ActionEvent e)
	{
		if(Arch.arch.inOutClipboard != null)
		{
			Arch.arch.inOutClipboard.in.setBackground(ColorStore.defaultGray);
		}
		//Store the associated storybrick in the clipboard
		Arch.arch.inOutClipboard = thisStoryBrick;
		thisStoryBrick.in.setBackground(ColorStore.selectColor);
	}


}
