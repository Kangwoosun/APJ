package mini_project;

import java.io.Serializable;

public class Doing implements Comparable<Doing>, Serializable{
	private int timeFrom;
	private int timeTo;
	private String toDo;
	
	public Doing(int timeFrom, int timeTo, String toDo) {
		super();
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.toDo = toDo;
	}
	/*
	 *  generalic get & set function
	 */
	public int getTimeFrom() {
		return this.timeFrom;
	}
	public void setTimeFrom(int timeFrom) {
		this.timeFrom = timeFrom;
	}
	public int getTimeTo() {
		return this.timeTo;
	}
	public void setTimeTo(int timeTo) {
		this.timeTo = timeTo;
	}
	public String getToDo() {
		return this.toDo;
	}
	public void setToDo(String toDo) {
		this.toDo = toDo;
	}
	
	// Using when display at jlist
	@Override
	public String toString() {
		return String.format("%02d:%02d - %02d:%02d %13s %s", timeFrom/60, timeFrom%60,
				timeTo/60, timeTo%60, new String("") ,toDo);
	}
	
	// Using when sort listDoing
	@Override
	public int compareTo(Doing anObject) {
		
		//If each start time are same, compare end time
		if(this.getTimeFrom() == anObject.getTimeFrom()) {
			
			//If each end time are same, compare ToDo
			if(this.getTimeTo() == anObject.getTimeTo()) {
				return this.getToDo().compareTo(anObject.getToDo());
			}
			else {
				if(this.getTimeTo() > anObject.getTimeTo()) return 1;
				else return -1;
			}
		}
		//If each start time are different, compare start time
		else {
			if(this.getTimeFrom() > anObject.getTimeFrom()) return 1;
			else return -1;
		}
			
	}
	// Using when compare originlistdoing and returned listdoing
	@Override
	public boolean equals(Object anObject) {
		if (anObject instanceof Doing)
			if( this == anObject) 
				return true;
		
		return false;
	}
	
}
