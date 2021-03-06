package com.liquidlabs.log.space;

public class Replay {
	private ReplayType type = ReplayType.START; 
	private int maxItems = 100;
	private int minItems;
	
	public Replay(){}
	public Replay(Replay toCopy){
		this.type = toCopy.type;
		this.maxItems = toCopy.maxItems;
		this.minItems = toCopy.minItems;
	}
	public boolean isFowards() {
		return type.equals(ReplayType.START);
	}
	public Replay(ReplayType type, int maxItems) {
		this(type, maxItems, 0);
	}
	public Replay(ReplayType type, int maxItems, int minItems) {
		this.type = type;
		this.maxItems = maxItems;
		this.minItems = minItems;
	}
	
	public long startFrom(long searchedFrom, long searchedTo) {
		if (type.equals(ReplayType.START)) {
			return searchedFrom;
		}
		
		if (type.equals(ReplayType.MIDDLE)) {
			long searchTime = searchedTo - searchedFrom;
			return searchedFrom + (searchTime / 2);
		}
		
		return -1;
	}

	public int maxItems() {
		return maxItems;
	}
	public int minItems() {
		return minItems;
	}
	public boolean isBackwards() {
		return type.equals(ReplayType.END);
	}
	public void setMaxItems(int maxItems) {
		this.maxItems = maxItems;
	}
	/**
	 * @generated by CodeSugar http://sourceforge.net/projects/codesugar */
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[Replay:");
		buffer.append(" type:");
		buffer.append(type);
		buffer.append(" maxItems:");
		buffer.append(maxItems);
		buffer.append(" minItems:");
		buffer.append(minItems);
		buffer.append("]");
		return buffer.toString();
	}
}
