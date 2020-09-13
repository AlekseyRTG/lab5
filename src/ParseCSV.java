import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;
public class ParseCSV
{
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception
    {
        String lin;
        int id;
        //Build reader instance
        CSVReader reader = new CSVReader(new FileReader("B:\\Proga\\out\\production\\Proga\\Bd.csv"), ',', '"', 1);
        //Read all rows at once
        List<String[]> allRows = reader.readAll();
        //Read CSV line by line and use the string array as you want
        for(String[] row : allRows){
            id = 1;
            lin = Arrays.toString(row);
            lin = lin.replace("[", "");
            lin = lin.replace("]", "");
            String[] massiv = lin.split(";");
            if(massiv.length != 15){
                System.out.println("\nОшибка в имени объекта! Символ ';' запрещен\n");
            }else{
                System.out.println(lin);
                Buffer.id = id++;
                Buffer.Orgid = id +5;
                Buffer.OrgName = massiv[0];
                Buffer.fullName = massiv[1];
                Buffer.postal = massiv[2];
                Buffer.OrganizationType = massiv[3];
                Buffer.town = massiv[4];
                Buffer.street = massiv[5];
                Buffer.Locx = massiv[6];
                Buffer.Locy = massiv[7];
                Buffer.Locz = massiv[8];
                Buffer.name = massiv[9];
                Buffer.Corx = massiv[10];
                Buffer.Cory = massiv[11];
                Buffer.creationDate = massiv[12];
                Buffer.unitOfMeasure = massiv[13];
                Buffer.price = massiv[14];


            }

        }
    }
}
