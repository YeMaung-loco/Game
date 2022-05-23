import Model.Computer;
import Model.Player;

public class Game {
	static Computer mComputer;
	static View view;
	static Player mPlayer;

	public static void main(String[] args) {
		view = new View();
		mComputer = new Computer();
		mPlayer = new Player();
		Controller controller = new Controller(mComputer, mPlayer, view);
		controller.initController();

	}

}
