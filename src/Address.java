public class Address {
    private String street;
    private Location town;

    //Инкапсуляция
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}

    public Location getTown() {return town;}
    public void setTown(Location town) {this.town = town;}
}
