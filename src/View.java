import java.awt.Font;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View {

	JFrame frame;
	JTextField txtNumber;
	JLabel lblHb, lblChance;
	JButton btnPlay;
	static Vector<Integer> comVector;

	public View() {
		initComponents();
		setProperties();
		addComponents();
	}

	public void initComponents() {
		frame = new JFrame();
		txtNumber = new JTextField();
		btnPlay = new JButton();
		lblHb = new JLabel();
		lblChance = new JLabel();
	}

	public void setProperties() {
		frame.setTitle("Predict 4 Numbers");
		frame.setBounds(300, 300, 350, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);

		txtNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNumber.setBounds(60, 30, 216, 25);
		txtNumber.setColumns(10);

		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPlay.setText("Check");
		btnPlay.setBounds(120, 73, 85, 25);

		lblHb.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHb.setBounds(135, 120, 150, 25);

		lblChance.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChance.setBounds(50, 150, 250, 25);

	}

	public void addComponents() {
		frame.add(txtNumber);
		frame.add(btnPlay);
		frame.add(lblHb);
		frame.add(lblChance);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTxtNumber() {
		return txtNumber;
	}

	public JButton getBtnPlay() {
		return btnPlay;
	}

	public JLabel getLblHb() {
		return lblHb;
	}

	public JLabel getLblChance() {
		return lblChance;
	}

}
