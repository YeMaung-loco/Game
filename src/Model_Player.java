import java.util.Vector;
import javax.swing.JOptionPane;

public class Model_Player {
	Vector<Integer> player_list;
	View view;

	public Model_Player(View v) {
		player_list = new Vector<Integer>();

	}

	public void setMplayer(Vector<Integer> v) {
		this.player_list = v;
	}

	public Vector<Integer> getMplayer() {

		return this.player_list;
	}

}
