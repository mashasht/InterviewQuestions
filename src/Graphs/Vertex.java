package Graphs;

public class Vertex {
	enum Color{
		WHITE, GREY, BLACK;
	}
	
	private int value;
	public Vertex(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	public String toString() {
		return Integer.toString(this.value);
	}

}
