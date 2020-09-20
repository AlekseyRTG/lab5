package lab.collection;

public class Coordinates {
    private Double x; //Значение поля должно быть больше -449, Поле не может быть null
    private Float y;

    public Coordinates(Double x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }
}
