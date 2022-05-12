public interface istorage {

    void updategamedata(suduko game) throws IOException;

    suduko getgamedata() throws IOException;

}
