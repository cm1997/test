package org.cross.elscommon.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerIO {
	public static void writePO(Object ob, String file){
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file, false));
			oos.writeObject(ob);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("io exception!");
			e.printStackTrace();
		}	
	}
	public static Object readPO(String file){
		ObjectInputStream ois;
		Object ob = null;
		try {
			FileInputStream fi = new FileInputStream(file);
			ois = new ObjectInputStream(fi);
			try {
				ob = ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("io exception!");
			e.printStackTrace();
		}
		return ob;
	}
}
