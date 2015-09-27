/*Kimberly Disher
 * CIS 35B Lab 1
 */
package tester;

import automobile.*;
import util.*;

public class Driver {

	public static void main(String[] args) {
		FileIO modelMaker = new FileIO();
		Model car = null;
		Model car2 = null;
		car = makeCarModel(modelMaker, car);
		printModel(car, "First Loaded:");
		changeModel (car);
		printModel(car, "Added a color option:");
		modelMaker.serializeAutoObject("carLab1.ser", car);
		car2 = modelMaker.deserializeAutoModelObject("carLab1.ser", car2);
		printModel(car2, "Serialized and Deserialized:");
	}
	private static Model makeCarModel (FileIO modelMaker, Model car){
		return modelMaker.buildAutoModelObject("automobile.txt", car);
	}
	private static void changeModel (Model car){
		if (car != null){
			car.addOptionToSet("Color", "Super Grape Metallic Clearcoat", 0D);
		}
	}
	private static void printModel (Model car, String changeMsg)
	{
		System.out.println(changeMsg);
		System.out.println(car.toString());
		System.out.println("_____________________");
	}
}
