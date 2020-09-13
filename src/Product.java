import java.time.ZonedDateTime;

public class Product {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальное, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double price; //Значение поля должно быть больше 0
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Organization manufacturer; //Поле может быть null

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Coordinates getCoordinates() {return coordinates;}
    public void setCoordinates(Coordinates coordinates) {this.coordinates = coordinates;}

    public ZonedDateTime getCreationDate() {return creationDate;}
    public void setCreationDate(ZonedDateTime creationDate) {this.creationDate = creationDate;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public UnitOfMeasure getUnitOfMeasure() {return unitOfMeasure;}
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {this.unitOfMeasure = unitOfMeasure;}

    public Organization getManufacturer() {return manufacturer;}
    public void setManufacturer(Organization manufacturer) {this.manufacturer = manufacturer;}

}
