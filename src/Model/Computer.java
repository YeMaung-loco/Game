package Model;
import java.util.Vector;

public class Computer {

	Vector<Integer> computer_list;

	public Computer() {
		computer_list = new Vector<Integer>();
	}

	public void setMcomputer(Vector<Integer> v) {
		this.computer_list = v;

	}

	public Vector<Integer> getM_Computer() {

		return computer_list;

	}

}
