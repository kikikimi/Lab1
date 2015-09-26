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
        
	protected Option getOption(String value) {return this._options [this.findOptionByValue(value)];}
    
	protected Option getOption (int index) {return this._options[index];}
        
	protected double getOptionPrice (int index) {return this._options[index].getOptPrice();}
	protected String getOptionValue (int index) {return this._options[index].getOptValue();}
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
	protected int getOpsetSize(){return this._options.length;}
        
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
    protected void deleteOptionSet (int index){
       this._optName = "";
       for (int i = 0; i < this._options.length; i++){
           this._options[i].deleteOption();
       }
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
