package lab.collection;

public class Location {
    private Integer x;
    private Float y;
    private double z;

    public Integer getX() {return x;}
    public void setX(Integer x) {this.x = x;}

    public Float getY() {return y;}
    public void setY(Float y) {this.y = y;}

    public Double getZ() {return z;}
    public void setZ(Double z) {this.z = z;}

    public Location(Integer x, Float y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Location(){}
    public String toString() {
        return "(" + x + ";" + y + ";" + z + ")";
    }
}
