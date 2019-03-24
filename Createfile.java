import java.io.*;
import java.lang.*;
import java.util.*;

public class Createfile extends MyAnimation{
	
	private Formatter x;

	public void openFile(){
		try{
			x = new Formatter("sample.txt");
		}
		catch(Exception e){
			System.out.println("Can't see any file");
		}
	}
	public void addRecords(){
		x.format("%s%s%s", "19 ", "kc ", "kervinclark");
	}
	public void closeFile(){
		x.close();
	}
}