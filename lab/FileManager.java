package lab;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import lab.collection.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class FileManager {
    File collectionFile;

    /**
     * Загружает коллекцию из файла, указанного в аргументе.
     * @param filePath Путь к файлу коллекции.
     * @return Коллекция.
     */
    public LinkedList<Product> loadCollection(String filePath) {
        LinkedList<Product> collection = new LinkedList<>();
        if (!setFile(filePath)) return null;
        else try {
            CSVReader reader = new CSVReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(collectionFile))));
            System.out.println("Загрузка коллекции из файла " + collectionFile.getAbsolutePath());
            StringBuilder stringBuilder = new StringBuilder();
            String nextString[];
            while ((nextString = reader.readNext()) != null) {
                ReadCSV csv = new ReadCSV();
                Product product = csv.toCSV(nextString);
                collection.add(product);
            System.out.println("Коллекций успешно загружена. Добавлено " + collection.size() + " элементов.");
        }
        } catch (Exception e) {
            System.out.println("При чтении строк возникла ошибка");
            return null;
        }

        return collection;
    }

    /**
     * Проверяет файл коллекции.
     * @param path Путь к файлу
     * @return Результат проверки. true, если файл подходит для работы.
     */
    private boolean setFile(String path) {
        if (path == null) {
            System.out.println("File path " + path + " is wrong!!!");
            System.exit(1);
        }
        File CSVPath = new File(path);
        if (CSVPath.exists()) {
            setCollectionFile(CSVPath);
            System.out.println("Path " + path + " discovered.");
        } else {
            System.out.println("Path " + path + " does not exist.");
            try {
                System.out.println("Create a new file.");
                if (CSVPath.createNewFile()) {
                    System.out.println("File not created");
                }
                setCollectionFile(CSVPath);
                save(new LinkedList<>());
            } catch (IOException e) {
                System.out.println("Error creating file!!!");
                return false;
            }
        }
        if (!CSVPath.isFile()) {
            System.out.println("Path " + path + " does not contain a file name.");
            return false;
        } else {
            System.out.println("File " + path + " discovered.");
        }
        if (!(path.lastIndexOf(".csv") == path.length() - 5)) {
            System.out.println("Non .csv file format.");
            return false;
        }
        return true;
    }

    /**
     * Сохраняет коллекцию в файл.
     * @param collection Коллекция.
     * @return Успешность операции сохранения.
     */
    public boolean save(LinkedList<Product> collection) {
        if (!collectionFile.exists()) {
            System.out.println(("Невозможно сохранить файл. Файл по указанному пути (" + collectionFile.getAbsolutePath() + ") не существует."));
        } else if (!collectionFile.canRead() || !collectionFile.canWrite()) {
            System.out.println("Невозможно сохранить файл. Файл защищён от чтения и(или) записи.");
        } else {
            try {
                CSVWriter writer = new CSVWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(collectionFile))));
                for (Product p : collection) {
                    writer.writeNext(p.toString());
                    writer.flush();
                }
                System.out.println("Файл успешно сохранён.");
                return true;
            } catch (Exception ex) {
                System.out.println("При записи файла что-то пошло не так.");
            }
        }
        return false;
    }

    private void setCollectionFile(File collectionFile) {
        this.collectionFile = collectionFile;
    }
}

