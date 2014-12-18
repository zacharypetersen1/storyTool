package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dataStorage.ColorStore;
import prototype1.Arch;
import storyBrick.StoryBrick;

public class OutListener implements ActionListener {
	
	//we need to be able to access the info stored in the Arch
	Arch arch;
	//We also need to know which storybrick this listener is referring to
	StoryBrick thisStoryBrick;
	//and lastly we must know which output (usu. 1 unless the storybrick has multiple out's)
	int outNum;

	//Constructor
	public OutListener(StoryBrick setStory, int setNum, Arch setArch)
	{
		//Set all of the instance variables
		thisStoryBrick = setStory;
		outNum = setNum;
		arch = setArch;
	}
	
	//actionPerformed is triggered when clicking on the out button
	public void actionPerformed(ActionEvent e)
	{
		if(arch.inOutClipboard == null)
		{
			thisStoryBrick.setPointer(outNum, null);
			arch.panel.repaint();
			//if nothing stored in clipboard, do nothing
		}
		else
		{
			//or else set the pointer to what is stored in clipboard
			thisStoryBrick.setPointer(outNum, arch.inOutClipboard);
			Arch.arch.inOutClipboard.in.setBackground(ColorStore.defaultGray);
			//clear clipboard
			arch.inOutClipboard = null;
			//and redraw the flow lines
			arch.panel.repaint();
		}
	}
	
}
