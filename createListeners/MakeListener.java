package createListeners;

import infrastructure.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import storyBrick.*;
import graphics.*;

public class MakeListener implements ActionListener {

	Arch arch;
	
	public MakeListener(Arch setArch)
	{
		arch = setArch;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{	
			arch.starter.findStage();
			arch.starter.make();
		}
		catch(IOException ex)
		{
			System.out.println("failed");
		}
	}
	
}
