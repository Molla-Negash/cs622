package cs622met;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializableClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ModelShoppings> list = new ArrayList<>();
		File outFile = new File("C:\\Users\\mdray\\Desktop\\objectFile.dat");
				FileOutputStream fileOutputStream = null;
				try {
					fileOutputStream = new FileOutputStream(outFile);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ObjectOutputStream objectOutputStream = null;
				try {
					objectOutputStream = new ObjectOutputStream(fileOutputStream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					objectOutputStream.writeObject(list);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					objectOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				
				//--------------------------------------------------
				File inputFile = new File("C:\\Users\\mdray\\Desktop\\objectFile.dat");
				FileInputStream fileInputStream = null;
				try {
					fileInputStream = new FileInputStream(inputFile);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ObjectInputStream objectInputStream = null;
				try {
					objectInputStream = new ObjectInputStream(fileInputStream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					List<ModelShoppings> studentListRead = (ArrayList<ModelShoppings>) objectInputStream.readObject();
					String output = "";
					for (ModelShoppings student : studentListRead) {
						output += student.toString() + "\n";
					}

					

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			}
	


