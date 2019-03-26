import java.io.*;
import java.lang.*;
import java.util.*;

public class Createfile{
	
	private Formatter x;

	public void openFile(){
		try{
			x = new Formatter("NewFile.txt");
			System.out.println("A new File");
		}
		catch(Exception e){
			System.out.println("Can't see any file");
		}
	}
	public void addRecords(){
		x.format("%s%s%s", "MyAnimation.java" , "Draw.java" , "Monster.java");
	}
	public void closeFile(){
		x.close();
	}
}