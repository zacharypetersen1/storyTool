package infrastructure;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.*;


public class Story {
	
	public File outFile;
	RandomAccessFile accessFile;
	String fileName, fileDir;
	Scanner scan;
	public int counter = 0;
	public Controller controller;
	
	public void init() throws IOException
	{
		scan = new Scanner(System.in);
		System.out.println("Enter Script Name");
		fileName = scan.next();
		fileDir = "C:/Users/Zachary/Documents/my_eclipse_workspace/storyTool_Ptyp1/output/"+ fileName +".txt";
		outFile = new File(fileDir);
			
		PrintWriter writer = new PrintWriter(new FileWriter(outFile, true));
		writer.println("//Name: " + fileName);
		writer.println("");
		writer.close();
		
    	controller = new Controller(this);
	}
	
}