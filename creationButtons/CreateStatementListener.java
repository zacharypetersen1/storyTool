package creationButtons;

import infrastructure.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateStatementListener implements ActionListener {	
	
	Controller arch;
	
	public CreateStatementListener(Controller setArch)
	{
		arch = setArch;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		arch.addStatement();
	}
}
