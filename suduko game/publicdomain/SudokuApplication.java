import javafx.application.Application;
import com.wiseassblog.sudoku.buildlogic.SudokuBuildLogic;
import com.wiseassblog.sudoku.userinterface.IUserInterfaceContract;
import com.wiseassblog.sudoku.userinterface.UserInterfaceImpl;
import javafx.fxml.FXLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SudokuApplication extends Application {
    private IUserInterfaceContract.View uiImpl;

    @Override

    public void start(Stage primaryStage) throws Exception {
        uiImpl = new UserInterfaceImpl(primaryStage);
        try {
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
