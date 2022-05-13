public interface Istorage {

    void updategamedata(SudokuGame game) throws IOException;

    suduko getGameData() throws IOException;

}
