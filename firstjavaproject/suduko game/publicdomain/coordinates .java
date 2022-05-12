public class coordinates {
    private final int x;
    private final int y;

    public coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    @Override
    public boolean equals(object o){
        if (this==o) return true ;
        if (o==null) || getclass() != o.getclass()) return false ;
        coordinates that = (coordinates) o;
        return x==this.x && y==this.y;
    }

    @Override
    public int hashcode() {
        return objects.hash(x, y);
    }
}
