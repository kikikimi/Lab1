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
		return this._optset[index];
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
	public Double getOptionPrice(String optSetName, String optValue){
		int setIndex = findOptionSetIndex (optSetName);
		return getOptionPrice (setIndex, optValue);
		
	}
	public Double getOptionPrice(int optSetIndex, String optValue){
		if ((optSetIndex > -1) && (optSetIndex < this._optsetCount))
			return this._optset[optSetIndex].getOptionPriceByValue(optValue);
		else return null;
	}
	public Double getOptionPrice(int optSetIndex, int optIndex){
		boolean inbounds = false;
		if (optSetIndex > -1 && optSetIndex < this._optsetCount){
			if (optIndex > -1 && optIndex > this._optset[optSetIndex].getOptionCount())
				inbounds = true;
		}
		
		if (inbounds)
			return this._optset[optSetIndex].getOptionPrice(optIndex);
		else return null;
	}
    public String getOptionValue (int optSetIndex, int optIndex){
    	boolean inbounds = false;
    	if (optSetIndex > -1 && optSetIndex < this._optsetCount){
    		if (optIndex > -1 && optIndex < this._optset[optSetIndex].getOptionCount())
    			inbounds = true;
    	}
    	if (inbounds)
    		return this._optset[optSetIndex].getOptionValue(optIndex);
    	else return null;
    }
	public int findOptionSetIndex(String name){
		int index = 0;
        boolean found = false;
        while (!found && index < this._optsetCount)
        {
        	if (_optset[index].getOptName().indexOf(name) != -1)
        		found = true;
        	else index++;
        }
        if (found) 
        	return index;
        else return -1;
	}
	public int findOptionIndex(OptionSet opts, String optValue){
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
			_optset[_optsetCount].addOption(optVal, optPrice);
			return true;
		}
		else return false;
	}
	public boolean deleteOptionSet (int setIndex) {
		boolean deleted = false;
		if (setIndex > -1 && setIndex < this._optsetCount) {
			this._optset[setIndex] = null;
			deleted = this.moveUpOptSets(setIndex);
			this._optsetCount--;
		}
		return deleted;
			
	}
	public boolean deleteOption(int setIndex, String optValue){
		int optIndex;
		boolean deleted = false;
		if (setIndex > -1 && setIndex > this._optsetCount) {
			optIndex = this._optset[setIndex].findOptionIndexByValue(optValue);
			if (optIndex != -1) {
				deleted = this._optset[setIndex].deleteOption(optIndex);
			}
		}
		return deleted;
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
	
	private boolean moveUpOptSets (int emptyIndex){
		try{
			while (emptyIndex < this._optsetCount -2){ //optsetCount is supposed to hold the next empty index at the end of the array
				this._optset[emptyIndex] = this._optset[emptyIndex + 1];
				emptyIndex++;
			}
			this._optset[emptyIndex] = null;
			return true;
		}
		catch (IndexOutOfBoundsException e) {
			return false;
		}
		
	}

}
