/* Kimberly Disher
 * CIS 35B Lab 1
 */
package util;

import java.io.*;
import automobile.*;

public class FileIO {
	
	private static final int DEFAULT_GROUP_SZ = 20;
	FileIO() {}
	
	public Model buildAutoModelObject(String fileName, Model automodel) {

		boolean endFile = false;
		String line;
		try{
			FileReader fReader = new FileReader(fileName);
			BufferedReader bReader = new BufferedReader(fReader);
			
			while (!endFile)
			{
				line = bReader.readLine();
				if (line == null) 
					endFile = true;
				else this.parseLine(automodel, line);
			}
			bReader.close();
			fReader.close();
			return automodel;
		}
		catch(Exception e){
			System.out.println("Error reading model file: " + e.getMessage());
			return null;
		}
		
	}
	
	public Model deserializeAutoModelObject(String fileName, Model automodel) {
		try{
			ObjectInputStream objectIn = new ObjectInputStream (new FileInputStream (fileName));
			automodel = (Model) objectIn.readObject();
			objectIn.close();
			return automodel;
		}
		catch (Exception e){
			System.out.println("Error writing Serialized objects: " + e.getMessage());
			return null;
		}
		
	}
	//default deserialize to "automodel.ser"
	public Model deserializeAutoModelObject(Model automodel) {return deserializeAutoModelObject("automodel.ser", automodel);}
	
	public boolean serializeAutoObject(String fileName, Model automodel) {
		try{
			ObjectOutputStream objectOut = new ObjectOutputStream (new FileOutputStream (fileName));
			objectOut.writeObject(automodel);
			objectOut.close();
		return true;
		}
		catch (Exception e){
			System.out.println ("Error loading Serialized objects: " + e.getMessage());
			return false;
		}
	}
	
	public void parseLine(Model automodel, String line) {
		String [] splitLine = line.split(", ");

		try {
			
			if (splitLine[0].compareToIgnoreCase("model") == 0) {
				automodel.setModelName(splitLine[1]);
			}
			else if (splitLine[0].compareToIgnoreCase("model price") == 0) {
				automodel.setPrice(Double.parseDouble(splitLine[1]));
			}
			else if (splitLine[0].compareToIgnoreCase("optionsets") == 0 || 
					splitLine[0].compareToIgnoreCase("option sets") == 0) {
				try {
					automodel.initOptionSets(Integer.parseInt(splitLine[1]));
				}
				catch (Exception e) { //number not there or not an integer
					automodel.initOptionSets(DEFAULT_GROUP_SZ);
					System.out.println("Error with count of Option sets" + e.getMessage());
				}
			}
			else if (splitLine[0].compareToIgnoreCase("optionset") == 1) {
				try {
					automodel.addOptionSet(splitLine[1], Integer.parseInt(splitLine[2]));
				}
				catch (Exception e) { //number not there or not an integer
					automodel.addOptionSet(splitLine[1], DEFAULT_GROUP_SZ);
					System.out.println("Error with count of options" + e.getMessage());
				}
			}
			else if (splitLine[0].compareToIgnoreCase("option") == 0){
				automodel.addOptionToLastSet(splitLine[1], Double.parseDouble(splitLine[1]));
			}
		}
		catch (Exception e) {
			System.out.println ("Error parsing Model file." + e.getMessage());
		}
	}

}