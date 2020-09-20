package lab.collection;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class SpaceMarine implements Comparable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float health; //Поле может быть null, Значение поля должно быть больше 0
    private AstartesCategory category; //Поле может быть null
    private Weapon weaponType; //Поле не может быть null
    private MeleeWeapon meleeWeapon; //Поле может быть null

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setHealth(Float health) {
        this.health = health;
    }

    public void setCategory(AstartesCategory category) {
        this.category = category;
    }

    public void setWeaponType(Weapon weaponType) {
        this.weaponType = weaponType;
    }

    public void setMeleeWeapon(MeleeWeapon meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    private Chapter chapter; //Поле не может быть null
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    public SpaceMarine(long id, String name, Coordinates coordinates, LocalDateTime creationDate, Float health, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeaponType() {
        return weaponType;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "_______________________" + "\n" +
                "Id: " + id + "\n" +
                "Name: " + name + "\n" +
                "Coordinates: " + coordinates + "\n" +
                "CreationDate: " + creationDate + "\n" +
                "Health: " + health + "\n" +
                "Category: " + category + "\n" +
                "WeaponType: " + weaponType + "\n" +
                "MeleeWeapon: " + meleeWeapon + "\n" +
                "Chapter: " + chapter + "\n";
    }

    @Override
    public int compareTo(Object o) {
        int thisValue = -1;
        if (this.getMeleeWeapon() != null) thisValue = this.getMeleeWeapon().value;
        int oValue = -1;
        if (((SpaceMarine) o).getMeleeWeapon() != null) oValue = this.getMeleeWeapon().value;

        return thisValue - oValue;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Float getHealth() {
        return health;
    }

    public AstartesCategory getCategory() {
        return category;
    }

    public Chapter getChapter() {
        return chapter;
    }
}
