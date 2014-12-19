package creationButtons;

import infrastructure.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MakeListener implements ActionListener {

	Controller arch;
	
	public MakeListener(Controller setArch)
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
