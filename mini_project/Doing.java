package mini_project;

public class Doing implements Comparable<Doing>{
	private int timeFrom;
	private int timeTo;
	private String toDo;
	
	public Doing(int timeFrom, int timeTo, String toDo) {
		super();
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.toDo = toDo;
	}
	
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
	
	@Override
	public String toString() {
		return String.format("%02d:%02d - %02d:%02d %45s %s", timeFrom/60, timeFrom%60,
				timeTo/60, timeTo%60, new String("") ,toDo);
	}
	
	@Override
	public int compareTo(Doing anObject) {
		//���۽ð��� ���� ��� ���ð��� ����
		if(this.getTimeFrom() == anObject.getTimeFrom()) {
			//���ð��� ���� ��� ���� ��
			if(this.getTimeTo() == anObject.getTimeTo()) {
				return this.getToDo().compareTo(anObject.getToDo());
			}
			else {
				if(this.getTimeTo() > anObject.getTimeTo()) return 1;
				else return -1;
			}
		}
		//���۽ð��� �ٸ���� ���۽ð��� ����
		else {
			if(this.getTimeFrom() > anObject.getTimeFrom()) return 1;
			else return -1;
		}
			
	}
	
	
}
