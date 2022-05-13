public class SudokuUtilities {
    public static void copySudokuArrayValues(int[][] oldArray, int[][] newArray) {
        for (int xindex = 0; xindex < suduko.GRID_BOUNDARY; xindex++) {
            for (int yindex = 0; yindex < suduko.GRID_BOUNDARY; yindex++) {
                newArray[xindex][yindex] = oldArray[xindex][yindex];
            }
        }
    }

    public static int[][] copyToNewArray(int[][] oldArray) {
        int[][] newArray = new int[suduko.GRID_BOUNDARY][suduko.GRID_BOUNDARY];
        for (int xindex = 0; xindex < suduko.GRID_BOUNDARY; xindex++) {
            for (int yindex = 0; yindex < suduko.GRID_BOUNDARY; yindex++) {
                newArray[xindex][yindex] = oldArray[xindex][yindex];
            }
        }
    }

}
