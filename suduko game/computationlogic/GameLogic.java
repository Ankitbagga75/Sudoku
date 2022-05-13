import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameLogic {
    public static suduko getNewGame() {
        return new suduko(
                GameState.NEW,
                GameGenerator.getNewGameGrid());
    }

    public static boolean sudokuIsInvalid(int[][] grid) {

        if (rowsAreInvalid(grid))
            return true;
        if (columnsAreInvalid(grid))
            return true;
        if (squaresAreInvalid(grid))
            return true;
        else
            return false;
    }

    private static boolean columnsAreInvalid(int[][] grid) {
        for (int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++) {
            List<Integer> row = new ArrayList<>();
            for (int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++) {
                row.add(grid[xIndex][yIndex]);
            }
            if (collectionHasRepeats(row))
                return true;

        }

        return false;
    }

    private static boolean rowsAreInvalid(int[][] grid) {
        for (int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++) {
            List<Integer> row = new ArrayList<>();
            for (int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++) {
                row.add(grid[xIndex][yIndex]);
            }
            if (collectionHasRepeats(row))
                return true;

        }

        return false;
    }

    private static boolean squaresAreInvalid(int[][] grid) {
        if (rowOfsquaresISInvalid(Rows.TOP, grid))
            return true;
        if (rowOfsquaresISInvalid(Rows.MIDDLE, grid))
            return true;
        if (rowOfsquaresISInvalid(Rows.BOTTOM, grid))
            return true;
        return false;
    }

    private static boolean rowOfsquaresISInvalid(Rows value, int[][] grid) {
        switch (value) {
            case TOP:
                if (squaresAreInvalid(0, 0, grid))
                    return true;
                if (squaresAreInvalid(0, 3, grid))
                    return true;
                if (squaresAreInvalid(0, 6, grid))
                    return true;

                return false;

            case MIDDLE:
                if (squaresAreInvalid(0, 0, grid))
                    return true;
                if (squaresAreInvalid(0, 3, grid))
                    return true;
                if (squaresAreInvalid(0, 6, grid))
                    return true;

                return false;

            case BOTTOM:
                if (squaresAreInvalid(0, 0, grid))
                    return true;
                if (squaresAreInvalid(0, 3, grid))
                    return true;
                if (squaresAreInvalid(0, 6, grid))
                    return true;

                return false;

            default:
                return false;

        }
    }

    private static boolean squaresAreInvalid(int xIndex, int yINdex; int [][] grid){
        int yINdexEnd = yIndex+3;
        int xINdexEnd = xIndex+3;

        List<Integer> square = new ArrayList<>();
        while (yINdex<yINdexEnd){
            while (xIndex<xINdexEnd){
                square.add(
                    grid[xIndex][yINdex];
                );
                xIndex++;
            }
            xIndex-=3;
            yINdex++;
        }

        if (collectionHasRepeats(square)) return true ;
        return false;
    }

    public static boolean collectionHasRepeats(List<Integer> collection) {
        for (int index = 1; index <= GRID_BOUNDARY; index++) {
            if (Collections.frequency(collection, index) > 1)
                return true;
        }

        return false;
    }

    public static GameState checkforcompletion(int[][] grid) {
        if (sudokuIsInvalid(grid))
            return GameState.ACTIVE;
        if (tilesAreNotFilled(grid))
            return GameState.ACTIVE;
        return GameState.COMPLETE;
    }

    public static boolean tilesAreNotFilled(int[][] grid) {
        for (int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++) {
            for (int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++) {
                if (grid[xIndex][yIndex] == 0)
                    return true;
            }

        }
        return false;
    }

}
