package Model;
import java.util.Vector;
import javax.swing.text.View;

public class Player {
	Vector<Integer> player_list;

	public Player() {
		player_list = new Vector<Integer>();

	}

	public void setMplayer(Vector<Integer> v) {
		this.player_list = v;
	}

	public Vector<Integer> getMplayer() {

		return this.player_list;
	}

}
