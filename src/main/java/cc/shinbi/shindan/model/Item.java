package cc.shinbi.shindan.model;

public class Item {
	private int id;
	private String text;
	
	
	public Item(int id, String text) {
		this.id = id;
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	
	
}
