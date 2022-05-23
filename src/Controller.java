import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import Model.Computer;
import Model.Player;

public class Controller implements ActionListener, KeyListener {
	private Computer model_Computer;
	private View view;
	private Player model_Player;
	private int playTime;
	private GameImplement gameImp;

	public Controller(Computer c, Player p, View v) {
		this.model_Computer = c;
		this.model_Player = p;
		this.view = v;
		gameImp = new GameImplement(v);
		startGame();
	}

	private void startGame() {
		playTime = 0;
		Vector<Integer> v = gameImp.computerVector();
		model_Computer.setMcomputer(v);

		view.getTxtNumber().setText("");
		view.getLblHb().setText("");
		view.getLblChance().setText("You have 10 chances.");
		view.getLblChance().setForeground(Color.black);
		view.getLblChance().setBounds(70, 150, 250, 25);
	}

	public void initController() {
		view.getBtnPlay().addActionListener(this);
		view.getTxtNumber().addKeyListener(this);
	}

	private void play() {
		String msgString = gameImp.check(model_Computer.getM_Computer(), model_Player.getMplayer());

		view.getLblChance().setBounds(50, 150, 250, 25);
		view.getLblHb().setText(msgString);
		view.getLblHb().setForeground(Color.red);

		if (msgString == "4H0B") {
			view.getLblChance().setText("You Win!!!");
			view.getLblChance().setForeground(Color.blue);
			view.getLblChance().setBounds(120, 150, 250, 25);
			view.getLblHb().setForeground(Color.blue);
			view.getLblHb().setBounds(135, 120, 150, 25);
			newGame("You win!");
		} else {
			playTime++;
			int chance = 10 - playTime;

			msgString = "You have left " + String.valueOf(chance) + " chances.";
			view.getLblChance().setText(msgString);
			if (chance == 0) {
				msgString = "Game Over!";
				view.getLblHb().setText(msgString);
				view.getLblHb().setBounds(110, 120, 150, 25);
				view.getLblChance().setForeground(Color.red);
				newGame("You lose!");
			}
		}
	}

	private void newGame(String title) {
		if (JOptionPane.showConfirmDialog(null, "Start a new game?", title, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			startGame();

		} else {
			System.exit(0);
		}
	}

	private void playerInput() { // userinput ko check

		String numString = view.getTxtNumber().getText();
		boolean checkString = numString.matches("[1-9]+");

		if (numString.length() == 4 && !numString.contains(" ") && checkString) {
			Vector<Integer> pVector = gameImp.playerVector(numString);
			model_Player.setMplayer(pVector);
			play(); // error ma shi yin play mal

		} else {

			view.getTxtNumber().setText("");
			view.getTxtNumber().requestFocus(true);
			if (numString.length() > 4 || numString.length() < 4 || numString.contains(" ") || !checkString) {

				if (numString.contains("0"))
					JOptionPane.showMessageDialog(view.getFrame(), "\'0\' number not allowed!");

				else if (numString.contains(" ")) {
					if (numString.length() == 5) {
						JOptionPane.showMessageDialog(view.getFrame(), "Dont use Space!");

					} else
						JOptionPane.showMessageDialog(view.getFrame(), "Require 4 number without space!");
				} else if (!checkString)
					JOptionPane.showMessageDialog(view.getFrame(), "Please input Number format!");

				else {
					if (numString.length() < 4)
						JOptionPane.showMessageDialog(view.getFrame(), "Please input 4 numbers!");
					else
						JOptionPane.showMessageDialog(view.getFrame(), "Please input 4 numbers!");
				}
			}

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			playerInput();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(view.getBtnPlay())) {
			playerInput();
		}

	}

}
