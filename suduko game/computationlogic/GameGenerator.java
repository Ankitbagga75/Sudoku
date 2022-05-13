import java.util.ArrayList;
import java.util.Random;

public class GameGenerator {
    public static int[][] getNewGameGrid() {
        return unsolveGame(getSolvedGame());
    }

    private static int[][] unsolveGame(int[][] solvedGame) {
        Random random = new Random(System.currentTimeMillis());
        boolean solvable = false;
        int[][] solvableArray = new int[GRID_BOUNDARY][GRID_BOUNDARY];

        while (solvable == false) {
            SudokuUtilities.copySudokuArrayValues(solvedGame, solvableArray);
            int index = 0;
            while (index < 40) {
                int Xcoordinate = random.nextInt(GRID_BOUNDARY);
                int Ycoordinate = random.nextInt(GRID_BOUNDARY);

                if (solvableArray[Xcoordinate][Ycoordinate] != 0) {
                    solvableArray[Xcoordinate][Ycoordinate] = 0;
                    index++;
                }

            }

            int[][] toBeSolved = new int[GRID_BOUNDARY][GRID_BOUNDARY];
            SudokuUtilities.copySudokuArrayValues(solvableArray, toBeSolved);

            solvable = SudokuSolver.puzzleIsSolvable(toBeSolved);

        }

        return solvableArray;

    }

    public static int[][] getSolvedGame() {
        Random random = new Random(System.currentTimeMillis());
        int[][] newGrid = new int[GRID_BOUNDARY][GRID_BOUNDARY];
        for (int value = 1; value <= GRID_BOUNDARY; value++) {
            int allocations = 0;
            int interrupt = 0;

            List<coordinates> aallocTracker = new ArrayList<>();
            int attempt = 0;
            while (allocations < GRID_BOUNDARY) {
                if (interrupt > 200) {
                    allocTracker.forEach(coord -> {
                        newGrid[coord.getX()][coord.getY()] = 0;

                    });

                    interrupt = 0;
                    allocations = 0;
                    aallocTracker.clear();
                    attempt++;
                    if (attemp > 500) {
                        clearArray(newGrid);
                        attempt = 0;
                        value = 1;

                    }
                }
                int xcoordinate = random.nextInt(GRID_BOUNDARY);
                int ycoordinate = random.nextInt(GRID_BOUNDARY);
                if (newGrid[xcoordinate][ycoordinate] == 0) {
                    newGrid[xcoordinate][ycoordinate] = value;

                    if (GameLogic.sudokuIsInvalid(newGrid)) {
                        newGrid[xcoordinate][ycoordinate] = 0;
                        interrupt++;
                    } else {
                        allocTracker.add(new coordinates(xcoordinate, ycoordinate));
                        allocations++;

                    }
                }
            }
        }

        return newGrid;
    }

    private static void clearArray(int[][] newGrid) {
        for (int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++) {
            for (int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++) {
                newGrid[xIndex][yINdex] = 0;

            }
        }
    }

}
