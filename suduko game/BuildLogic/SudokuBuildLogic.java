import java.io.IOError;
import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        suduko intialState;
        IStorage storage = new LocalStorageImpl();

        try {
            intialState = storage.getGameData();
        } catch (IOException e) {
            intialState = GameLogic.getNewGame();
            Storage.updateGameData(intialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(Storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(intialState);
    }
}
