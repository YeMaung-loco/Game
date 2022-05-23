import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

public class GameImplement {
	View view;

	public GameImplement(View v) {
		this.view = v;

	}

	public Vector<Integer> computerVector() {
		int num;
		Random randomObj = new Random();
		Vector<Integer> list = new Vector<Integer>();
		while (list.size() < 4) {
			num = randomObj.nextInt(9) + 1;
			if (!list.contains(num)) {
				list.addElement(num);

			}
		}
		System.out.println("The numbers is " + list);
		return list;
	}

	public Vector<Integer> playerVector(String numString) {
		Vector<Integer> player_list = new Vector<Integer>();
		int num;
		for (int i = 0; i < 4; i++) {
			String n = Character.toString(numString.charAt(i));
			num = Integer.parseInt(n);
			if (player_list.contains(num)) {
				view.getTxtNumber().setText("");
				view.getTxtNumber().requestFocus(true);
				JOptionPane.showMessageDialog(view.getFrame(), "Duplicate!!!");
				player_list.removeAllElements();
				break;
			} else {
				player_list.addElement(num);
			}
		}
		return player_list;
	}

	public String check(Vector<Integer> computer, Vector<Integer> player) {
		System.out.println(computer + " vs " + player);
		int h = 0, b = 0;
		String msg = null;
		for (int i = 0; i < computer.size(); i++) {
			for (int j = 0; j < player.size(); j++) {
				if (computer.get(i) == player.get(j)) {
					if (i == j)
						h++;
					else
						b++;
				}

			}
		}
		if (h == 4) {
			msg = "4H0B";
			player.removeAllElements();

		} else {
			msg = h + "H" + b + "B";
			player.removeAllElements();
		}
		return msg;
	}

}
