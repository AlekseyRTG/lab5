package lab.collection;

public class Coordinates {
    private Long x; //Поле не должно быть null
    private Integer y; //Максимальное значение поля: 346, Поле не должно быть null

    public Coordinates(Long x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }
}
