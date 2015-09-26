/* Kimberly Disher
 * CIS 35B Lab 1
 */
package automobile;

import java.io.Serializable;
import java.text.*;
import java.util.*;

public class Model implements Serializable{
	private OptionSet [] _optset;
	private String _modelName;
	private double _price;
	private int _optsetCount;
	
	private static final long serialVersionUID = 1158L;
	
	Model(String nm, OptionSet [] opts, double price){
		
	}
	Model(String nm, int optSetSize, double price){
		this();
		setModelName(nm);
        setPrice(price);
        }
	Model(){_optsetCount = 0;}
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
	
	public void initOptionSets (int numSets)
	{
		this._optset = new OptionSet [numSets];
	}
	public double getOptionPrice(String optSetName, String optName){
		
	}
	public double getOptionPrice(int optSetIndex, String optName){
		
	}
	public double getOptionPrice(int optSetIndex, int optIndex){
		
	}
    public String getOptionValue (int optSetIndex, int optIndex){
            
    }
	public int findOptionSetIndex(String name){
		
	}
	public OptionSet.Option findOptionIndex(OptionSet opts, String optValue){
		return opts.findOptionIndexByValue(optValue);
	}
	public boolean addOptionSet(String setName, OptionSet.Option [] opts){
		if (addOptionSet(setName, opts.length)){
			_optset[_optsetCount -1].setOptions(opts);
			return true;
		}
		else return false;
	}
	public boolean addOptionSet(String setName, int setSize) {
		if (_optsetCount < _optset.length) {
			_optset[_optsetCount++] = new OptionSet(setSize, setName);
			return true;
		}
		else return false;
	}
	public int addOptionToSet(String setName, String optVal, double optPrice){
		
	}
	public int addOptionToSet(int setIndex, String optVal, double optPrice){
		
	}
	public boolean addOptionToLastSet (String optVal, double optPrice){
		if (_optsetCount < _optset.length) {
			_optset[_optsetCount].addOption(optVale, optPrice);
		}
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
	public void initOptionSet (int size){
            this._optset = new OptionSet [size];
        }
	public String toString(){
		StringBuilder sb = new StringBuilder(this._modelName);
		sb.append(NumberFormat
                        .getCurrencyInstance(new Locale("en", "US"))
                        .format(_price));
		for(int i = 0; i < _optset.length; i++){
			sb.append("\t");
			sb.append(this._optset[i].toStringHelper());
		}
                return sb.toString();
	}

}
