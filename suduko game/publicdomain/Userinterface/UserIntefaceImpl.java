import java.util.HashMap;

import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.HashMap;

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

    public UserIntefaceImpl(Stage stage) {
        this.stage = stage;
        this.root = new Group();
        this.textFieldCoordinates = new HashMap<>();
        initializeUserInterface();
    }

    public void initializeUserInterface() {
        drawBackground(root);
        drawTitle(root);
        drawBoard(root);
        drawTextFields(root);
        drawGridLines(root);
        stage.show();

    }

    private void drawTitle(Group root){
        Text title = new Text(235,690,SUDOKU);
        title.setFill(Color.WHITE);
        Font titleFont = new Font (43);
        title.setFont(titleFont)
        root.getChildren().add(title);
    }

    private void drawGridLines(Group root){
        int xANDY = 114;
        int index = 0;
        while (index<8){
            int thickness;
            if(index ==2 || index==5){
                thickness = 3;
            }else{
                thickness=2;
            }

        Rectangle verticalLine = getLine(xANDY + 64*index,BOARD_PADDING,BOARD_X_AND_Y,thickness);
        Rectangle horizontalLine = getLine(BOARD_PADDING,xANDY + 64*index,thickness,BOARD_X_AND_Y);
        
        root.getChildren().addAll(
            verticalLine;
            horizontalLine;
        );

        index++;
        }
    }

    private Rectangle getLine(double x, double y, double height, double width) {
        Rectangle line = new Rectangle();
        line.setX(x);
        line.setY(y);
        line.setHeight(height);
        line.setWidth(width);

        line.setFill(Color.BLACK);
        return line;

    }

    private void drawTextFields(Group root) {
        final int xorigin = 50;
        final int yorigin = 50;

        final int xANDYDelta = 64;
        for (int xindex = 0; xindex < 9; xindex++) {
            for (int yindex = 0; yindex < 9; yindex++) {
                int x = xorigin + xindex + xANDYDelta;
                int y = yorigin + yindex + xANDYDelta;

                SudokuTextField title = new SudokuTextField(xindex, yindex);

                StyleSudokuTile(tile, x, y);
                tile.setOnKeyPressed(this);
                textFieldCoordinates.put(new coordinates(xindex, yindex), tile);
                root.getChildren().add(tile);
            }
        }
    }

    private void StyleSudokuTile(SudokuTextField tile, double x, double y) {
        Font numberFont = new Font(32);
        tile.setFont(numberFont);
        tile.setAlignment(Pos.CENTER);
        tile.setLayoutX(x);
        tile.setLayoutY(y);
        tile.setPrefHeight(64);
        tile.setPrefWidth(64);

        tile.Background(Background.EMPTY);
    }

    private void drawSudokuBoard(Group root) {
        Rectangle BoardBackground = new Rectangle();
        BoardBackground.setX(BOARD_PADDIND);
        BoardBackground.setY(BOARD_PADDIND);
        BoardBackground.setWidth(BOARD_X_AND_Y);
        BoardBackground.setHeight(BOARD_X_AND_Y);
        root.getChildren().addall(BoardBackground);
    }

    private void drawBackground(Group root) {
        Scene scene = new Scene(root, WINDOW_X, WINDOW_Y);
        scene.setFill(WINDOW_BACKGROUND_COLOR);
        stage.setScene(scene);
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if (event.getEventType() == KeyEvent.KEY_PRESSED) {
            if (event.getText().matches("[0-9]")) {
                int value = Integer.parseInt(event.getText());
                handleInput(value, event.getsource());
            } else if (event.getCode() == keyCode.BACK_SPACE) {
                handleInput(0, event.getsource());
            } else {
                ((TextField) event.getSource()).setText("");
            }
        }

        event.consume();
    }

    @Override
    public void setListener(IUserInterfaceContract.EventListener listener) {
        this.listener = listener;
    }

    @Override
    public void updateSquare(int x, int y, int input) {
        SudokuTextField tile = textFieldCoordinates.get(new coordinates(x, y));
        String value = Integer.toString(input);
        if (value.equals("0"))
            value = "";
        tile.textProperty().setValue(value);
    }

    @Override
    public void updateBoard(suduko game) {
        for (int xindex = 0; xindex < 9; xindex++) {
            for (int yindex = 0; yindex < 9; yindex++) {
                TextField tile = textFieldCoordinates.get(new Coordinates(xindex, yindex));

                String value = Integer.toString(game.getCopyOfGridState()[xindex][yindex]);
                if (value.equals("0"))
                    value = "";
                tile.setText(value);
                if (game.getGameState() == GameState.NEW) {
                    if (value.equals("")) {
                        tile.setStyle("-fx-opacity : 1;");
                        tile.setDisable(false);
                    } else {
                        tile.setStyle("-fx-opacity : 0.8;");
                        tile.setDisable(true);
                    }
                }
            }
        }
    }

    @Override
    public void showDialog(String Message) {
        ALert Dialog = new Alert(Alert.type.CONFIRMATION, message, ButtonType.OK);
        dialog.showAndWait();
        if (dialog.getResult() == ButtomType.OK)
            listener.onDialogClick();
    }

    @Override
    public void showError(String message) {
        ALert dialog = new Alert(Alert.type.CONFIRMATION, message, ButtonType.OK);
        dialog.showAndWait();
    }

    private void handleInput(int value, Object source) {
        listener.onsudokuInput(((SudokuTextField) source).getX(), ((SudokuTextField) source).getY(), value);

    }
}
