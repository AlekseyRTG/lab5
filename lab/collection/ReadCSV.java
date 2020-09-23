package lab.collection;

import java.time.ZonedDateTime;

public class ReadCSV {
    public Product toCSV(String[] data){
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        Long x = Long.valueOf(data[2]);
        Integer y = Integer.valueOf(data[3]);
        java.time.ZonedDateTime dateTime = ZonedDateTime.parse(data[4]);
        double price = Double.parseDouble(data[5]);
        UnitOfMeasure unitOfMeasure = UnitOfMeasure.valueOf(data[6]);
        long orgid = Long.parseLong(data[7]);
        String orgName = data[8];
        String fullorgName = data[9];
        OrganizationType type = OrganizationType.valueOf(data[10]);
        String street = data[11];
        Integer Lx = Integer.valueOf(data[12]);
        Float Ly = Float.valueOf(data[13]);
        double Lz = Double.parseDouble(data[14]);
        Location town = new Location(Lx,Ly,Lz);
        Address postalAddress = new Address(street,town);
        Organization org = new Organization(orgid,orgName,fullorgName,type,postalAddress);
        Coordinates cords = new Coordinates(x,y);
        return new Product(id,name,cords,dateTime,price,unitOfMeasure,org);
    }
}
