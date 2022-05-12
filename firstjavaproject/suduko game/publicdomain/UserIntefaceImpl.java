import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class UserIntefaceImpl implements IUserInterfaceContract.view, EventHandler<KeyEvent> {
    private final Stage stage;
    private final Group root;

    private HashMap<Coordinates, SudokuTextField> textFieldCoordinates;

    private IUserInterfaceContract.EventListener listener;
    private static final double WINDOW_Y = 732;
    private static final double WINDOW_X = 668;
    private static final double BOARD_PADDIND = 50;
    private static final double BOARD_X_AND_Y = 576;

    private static final Color WINDOW_BACKGROUND_COLOR = Color.rdb(0, 150, 136);
    private static final Color BOARD_BACKGROUND_COLOR = Color.rdb(224, 242, 241);
    private static final String SUDOKU = "Sudoku";

    @Override
    public void handle(KeyEvent keyEvent) {

    }

    @Override
    public void setListener(IUserInterfaceContract.EventListener listener) {

    }

    @Override
    public void updateSquare(int x, int y, int input) {

    }

    @Override
    public void updateBoard(suduko game) {

    }

    @Override
    public void showDialog(String Message) {

    }

    @Override
    public void showError(String message) {

    }
}
