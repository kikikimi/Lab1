/* Kimberly Disher
 * CIS 35B Lab 1
 */
package automobile;

import java.text.*;
import java.util.*;
import java.io.Serializable;

class OptionSet implements Serializable{
	private String _optName;
	private Option [] _options;
	private int _optCount;
	private static final long serialVersionUID = 1158L;
	
	OptionSet (int size, String nm){
		this (nm);
		this._options = new Option[size];
	}
	OptionSet (String nm){
		setOptName (nm);
		_optCount = 0;
	}
	protected String getOptName() {return _optName;}
        
	protected void setOptName(String optName) {this._optName = optName;}
        
	protected Option[] getOptions() {return _options;}
        
	protected Option getOption(String value) {return this._options [this.findOptionIndexByValue(value)];}
    
	protected Option getOption (int index) {return this._options[index];}
        
	protected double getOptionPrice (int index) {return this._options[index].getOptPrice();}
	protected String getOptionValue (int index) {return this._options[index].getOptValue();}
	protected Double getOptionPriceByValue (String optValue) {
		int optIndex = findOptionIndexByValue(optValue);
		if (optIndex > -1)
			return this._options[optIndex]._optPrice;
		else return null;
	}
	protected void setOptions(Option[] options) {
		for (Option opt : options){
			this.addOption (opt._optValue, opt._optPrice);
		}
	}
	protected boolean addOption (String optValue, double optPrice){
		if (_optCount < _options.length){
			_options[_optCount++] = new Option(optValue, optPrice);
			return true;
		}
		else 
			return false;
	}
	protected boolean updateOptionPrice (String optVal, double price) {
		boolean updated = false;
		int optIndex = this.findOptionIndexByValue(optVal);
		if (optIndex != -1) {
			this._options[optIndex].setOptPrice(price);
			updated = true;
		}
		return updated;
	}
	protected boolean updateOptionValue (String optVal, String newOptVal) {
		boolean updated = false;
		int optIndex = this.findOptionIndexByValue(optVal);
		if (optIndex != -1) {
			this._options[optIndex].setOptValue(newOptVal);
			updated = true;
		}
		return updated;
	}
	protected int getOpsetSize(){return this._options.length;}
	protected int getOptionCount(){return this._optCount;}    
    protected int findOptionIndexByValue (String optValue){
        int index = 0;
        boolean found = false;
        while (!found && index < this._optCount)
        {
        	if (_options[index].getOptValue().indexOf(optValue) != -1)
        		found = true;
        	else index++;
        }
        if (found) 
        	return index;
        else return -1;
    }
    protected boolean deleteOption (int optIndex){
    	boolean deleted = false;
		if (optIndex > -1 && optIndex < this._optCount) {
			this._options[optIndex] = null;
			deleted = this.moveUpOptions(optIndex);
			this._optCount--;
		}
		return deleted;
    }
	protected String toStringHelper(){
		StringBuilder sb = new StringBuilder (_optName);
		sb.append("\n");
		for (int i = 0; i < this._options.length; i++){
			sb.append("\t");
			sb.append(this._options[i].toStringHelper());
			sb.append("\n");
		}
                return sb.toString();
	}
	protected boolean updateOptionsSize (int size) {
		if (size > this._optCount) { //make sure the new array is large enough to copy all existing options
			
			Option [] options = new Option [size];
			for (int i = 0; i < _optCount; i++) {
				options [i] = this._options [i];
			}
			_options = options;
			return true;
		}
		else return false;
		
	}
	
	private boolean moveUpOptions (int emptyIndex){
		try{
			while (emptyIndex < this._optCount -2){ //optCount is supposed to hold the next empty index at the end of the array
				this._options[emptyIndex] = this._options[emptyIndex + 1];
				emptyIndex++;
			}
			this._options[emptyIndex] = null;
			return true;
		}
		catch (IndexOutOfBoundsException e) {
			return false;
		}
		
	}
        
	class Option implements Serializable{
		private String _optValue;
		private double _optPrice;
		private static final long serialVersionUID = 1158L;
		
		protected Option (){}
		protected Option (Option opt) { 
			this._optValue = opt._optValue;
			this._optPrice = opt._optPrice;
		}
		protected Option (String value, double price){}
		
		protected String getOptValue() {return _optValue;}
		protected void setOptValue(String optValue) {this._optValue = optValue;}
		protected double getOptPrice() {return _optPrice;}
		protected void setOptPrice(double optPrice) {this._optPrice = optPrice;}
		protected void deleteOption () {
			this._optPrice = 0;
			this._optValue = "";
		}

		protected String toStringHelper() {
			StringBuilder sb = new StringBuilder (_optValue);
			sb.append(", Price: ");
			sb.append(NumberFormat
                                .getCurrencyInstance(new Locale("en", "US"))
                                .format(_optPrice));
			return sb.toString();
		}
	}
}
