import java.time.LocalDate;
import java.time.ZonedDateTime;

public class ProductMacker {

    public static Product ProductFromBuffer(){
        Product pr = new Product();
        pr.setId(Buffer.id);
        ProductMacker.NameFromBuffer(pr);
        ProductMacker.CoordFromBuffer(pr);
        ProductMacker.CreationTimeFromBuffer(pr);
        ProductMacker.PriceFromBuffer(pr);
        ProductMacker.unitOfMeasure(pr);
        System.out.println(pr);
        return pr;
    }

    public static void NameFromBuffer(Product pr){
        pr.setName(Buffer.name);
    }

    public static void CoordFromBuffer(Product pr){
        Coordinates cor = new Coordinates();
        cor.setX(Long.parseLong(Buffer.Corx));
        cor.setY(Integer.parseInt(Buffer.Cory));
        pr.setCoordinates(cor);

    }
    public static void CreationTimeFromBuffer(Product pr){
        ZonedDateTime zdt = ZonedDateTime.parse(Buffer.creationDate);
        pr.setCreationDate(zdt);
    }

    public static void PriceFromBuffer(Product pr){
        pr.setPrice(Double.parseDouble(Buffer.price));
    }

    public static void unitOfMeasure(Product pr){
        pr.setUnitOfMeasure(UnitOfMeasure.getUnit(Buffer.unitOfMeasure));
    }

}

