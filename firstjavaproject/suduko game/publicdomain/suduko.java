import java.io.Serializable;
import javax.management.monitor.GaugeMonitor;

public class suduko implements Serializable {
private final GameState gamestate;
private final int[][] gridstate;

public static final int GRID_BOUNDARY = 9;

public suduko(GameState gamestate , int [][] gridstate){
    this.gamestate = gamestate;
    this.gridstate = gridstate;
}

public GameState getgamestate(){
    return gamestate;
}

public int[][] getcopyofgridstate(){
    return sudokuUtilities.copytoNewArray(gridstate);
}


}
