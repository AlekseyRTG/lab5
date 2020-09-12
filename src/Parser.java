import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    //Основной метод приложения
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\_ForSO\\CsvTest\\CsvFile.txt ";
        List<Product> products = ParseProductCsv(filePath);

        //Тут вызов метода или прямая обработка полученных продуктов
    }

    //Расинг CSV файла по указанному пути и получение продуктов из него
    private static List<Product> ParseProductCsv(String filePath) throws IOException {
        //Загружаем строки из файла
        List<Product> products = new ArrayList<Product>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split(",");
            ArrayList<String> columnList = new ArrayList<String>();
            for (int i = 0; i < splitedText.length; i++) {
                //Если колонка начинается на кавычки или заканчиваеться на кавычки
                if (IsColumnPart(splitedText[i])) {
                    String lastText = columnList.get(columnList.size() - 1);
                    columnList.set(columnList.size() - 1, lastText + ","+ splitedText[i]);
                } else {
                    columnList.add(splitedText[i]);
                }
            }
            Product product = new Product();
            product.Name = columnList.get(0);
            product.PurchasePrice = columnList.get(1);
            product.Group = columnList.get(2);
            product.Amount = columnList.get(3);
            product.Composition = columnList.get(4);
            product.Count = columnList.get(5);
            products.add(product);
        }
        return products;
        System.out.println(products);
    }

    //Проверка является ли колонка частью предыдущей колонки
    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        //Если в тексте одна ковычка и текст на нее заканчиваеться значит это часть предыдущей колонки
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }

}