package tptty.example07;

public class SuperObject {

	protected String name;
	public void paint() {
		draw();
	}
	public void draw() {
		System.out.println("Super Object");
	}
	public static void main(String[] args) {
		SuperObject a = new SuperObject();
		a.paint();
	}

}
