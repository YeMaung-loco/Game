import java.util.Vector;

class Model_Computer {

	Vector<Integer> computer_list;

	public Model_Computer() {
		computer_list = new Vector<Integer>();
	}

	public void setMcomputer(Vector<Integer> v) {
		this.computer_list = v;

	}

	public Vector<Integer> getM_Computer() {

		return computer_list;

	}

}
