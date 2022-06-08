import Model.Computer;
import Model.Player;

public class Game {
	public static void main(String[] args) {
		View view = new View();
		Computer mComputer = new Computer();
		Player mPlayer = new Player();
		Controller controller = new Controller(mComputer, mPlayer, view);
	}

}
