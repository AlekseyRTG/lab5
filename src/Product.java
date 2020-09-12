public class Product {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальное, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double price; //Значение поля должно быть больше 0
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Organization manufacturer; //Поле может быть null
}
