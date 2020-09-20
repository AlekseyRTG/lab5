package lab.collection;

public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long marinesCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000
    private String world; //Поле не может быть null

    public Chapter() {
    }

    public Chapter(String name, Long marinesCount, String world) {
        this.name = name;
        this.marinesCount = marinesCount;
        this.world = world;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMarinesCount() {
        return marinesCount;
    }

    public void setMarinesCount(Long marinesCount) {
        this.marinesCount = marinesCount;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "       MarinesCount: " + marinesCount + "\n" +
                "       World: " + world + "\n";
    }
}