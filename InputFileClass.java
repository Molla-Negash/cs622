package cs622met;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class InputFileClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<ModelShoppings> list = new ArrayList<>();
		File outFile = new File("C:\\Users\\mdray\\Desktop\\shoppinglist.txt");
		FileWriter fWriter = null;
		
			fWriter = new FileWriter(outFile);
			
			
	
		PrintWriter pWriter = new PrintWriter(fWriter);
		System.out.println(pWriter);
		pWriter.println(list);
		pWriter.println();

		pWriter.close();

	}

}
