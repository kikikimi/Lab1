package automobile;

import java.io.Serializable;
import java.text.*;
import java.util.*;

class Model implements Serializable{
	private OptionSet [] _optset;
	private String _modelName;
	private double _price;
	
	private static final long serialVersionUID;
	Model(String nm, OptionSet [] opts, double price){
		
	}
	Model(String nm, int optSetSize, double price){
		
	}
	Model(){
		
	}
	public OptionSet[] getOptionSet() {
		return _optset;
	}
	public OptionSet getOptionSet(int index){
		
	}
	public void setOptionset(OptionSet[] optset) {
		this._optset = optset;
	}
	public String getModelName() {
		return _modelName;
	}
	public void setModelName(String name) {
		this._modelName = name;
	}
	public double getPrice() {
		return _price;
	}
	public void setPrice(double price) {
		this._price = price;
	}
	
	public double getOptionPrice(String optSetName, String optName){
		
	}
	public double getOptionPrice(int optSetIndex, String optName){
		
	}
	public double getOptionPrice(int optSetIndex, int optIndex){
		
	}
	public int findOptionSetIndex(String name){
		
	}
	public OptionSet.Option findOption(OptionSet opts, String optValue){
		
	}
	public int addOptionSet(String setName, OptionSet.Option [] opts){
		
	}
	public int addOptionToSet(String setName, String optVal, double optPrice){
		
	}
	public int addOptionToSet(int setIndex, String optVal, double optPrice){
		
	}
	public int deleteOptionSet (int setIndex) {
		
	}
	public int deleteOption(int setIndex, String optValue){
		
	}
	public int deleteOption(String setName, String optValue){
		
	}
	public int deleteOption(int setIndex, int optIndex){
		
	}
	public int updateOptionSet (int setIndex, String setName, int size){
		
	}
	public int updateOption(int setIndex, String optName, double optPrice){
		
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder(this._modelName);
		//I never remember how to do number formatting so I borrowed most of this line from http://stackoverflow.com/questions/2379221/java-currency-number-format
		sb.append(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(_price));
		for(int i = 0; i < _optset.length; i++){
			sb.append("\t");
			sb.append(this._optset[i].toStringHelper());
		}
	}

}
