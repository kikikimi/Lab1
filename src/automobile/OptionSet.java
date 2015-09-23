package automobile;

class OptionSet {
	private String _optName;
	private Option [] _options;
	private int _currOptIndex;
	
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
	
	
	class Option {
		private String _optValue;
		private double _optPrice;
		
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
		
		//fix this
		protected String toString() {
			StringBuilder sb = new StringBuilder (_optValue);
			sb.append(", Price: ");
			sb.append(_optPrice);
			return sb.toString();
		}
	}
}
