package automobile;

import java.text.*;
import java.util.*;

class OptionSet {
	private String _optName;
	private Option [] _options;
	private int _currOptIndex;
	private static final long serialVersionUID;
	
	OptionSet (int size, String nm){
		setOptName (nm);
		this._options = new Option[size];
	}
	OptionSet (String nm){
		
	}
	protected String getOptName() {
		return _optName;
	}
	protected void setOptName(String optName) {
		this._optName = optName;
	}
	protected Option[] getOptions() {
		return _options;
	}
	protected Option getOption(String nm){
		
	}
	protected double getOptionPrice (){
		
	}
	protected String getOptionName () {
		
	}
	protected void setOptions(Option[] options) {
		//remember not to leave this like it is
		this._options = options;
	}
	protected int getOpsetSize(){}
	protected int getCurrOptIndex(){}
	protected String toStringHelper(){
		StringBuilder sb = new StringBuilder (_optName);
		sb.append("\n");
		for (int i = 0; i < this._options.length; i++){
			sb.append("\t");
			sb.append(this._options[i].toStringHelper());
			sb.append("\n");
		}
	}
	
	
	class Option {
		private String _optValue;
		private double _optPrice;
		private static final long serialVersionUID;
		
		protected Option (){}
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
			//I never remember how to do number formatting so I borrowed most of this line from http://stackoverflow.com/questions/2379221/java-currency-number-format
			sb.append(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(_optPrice));
			return sb.toString();
		}
	}
}
