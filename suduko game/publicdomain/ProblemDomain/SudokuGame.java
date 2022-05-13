import java.io.Serializable;
import javax.management.monitor.GaugeMonitor;

public class SudokuGame implements Serializable {
    private final GameState gameState;
    private final int[][] gridState;

    public static final int GRID_BOUNDARY = 9;

    public SudokuGame(GameState gameState, int[][] gridState) {
        this.gameState = gameState;
        this.gridState = gridState;
    }

    public GameState getGameState() {
        return gamestate;
    }

    public int[][] getCopyOfGridState() {
        return sudokuUtilities.copyToNewArray(gridState);
    }

}
