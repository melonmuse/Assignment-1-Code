public class coordinate {
    private final int column;
    private final int row;
    

    public coordinate(int column, int row){
        this.column = column;
        this.row = row;
    }

    public int getColumn(){
        return column;
    }

    public int getRow(){
        return row;
    }


    @Override 
    public boolean equals(Object obj){
        if (this == obj) returns true;
        if (!(obj instanceof coordinate)) return false;
        coordinate other = (coordinate) obj;
        return row == other.row && column == other.column;
    }

    @Override 
    public String toString(){
        return "()" + row + "," + column + 
        ")";
    }

    @Override 
    public int hashCode(){
        return 31 * row + column;
    }
}
