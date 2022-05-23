
public class Game {
	static Model_Computer mComputer;
	static View view;
	static Model_Player mPlayer;

	public static void main(String[] args) {
		view = new View();
		mComputer = new Model_Computer();
		mPlayer = new Model_Player(view);
		Controller controller = new Controller(mComputer, mPlayer, view);
		controller.initController();

	}

}
