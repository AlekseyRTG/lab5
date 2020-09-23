package lab;

import java.util.LinkedList;

import lab.collection.*;
/**
 * Класс доступа к коллекции
 */
public class CollectionControl {
    FileManager fileManager = new FileManager();
    LinkedList<Product> collection;
    public LinkedList<Product> getCollection() {
        return collection;
    }

    /**
     * Загружает коллекцию из файла.
     * @param filePath Путь к файлу.
     * @return Успешность загрузки.
     */
    public boolean loadCollection(String filePath) {
        collection = fileManager.loadCollection(filePath);
        return collection != null;
    }

    /**
     * Cохраняет коллекцию в файл, из которого она была загружена.
     * @return Успешность сохранения.
     */
    public boolean saveCollection(){
        return fileManager.save(collection);
    }

    /**
     * Выводит информацию о коллекции.
     */
    @Override
    public String toString() {
        return "Информация о коллекции:\n" +
                "Файл коллекции: " + fileManager.collectionFile.getAbsolutePath() +"\n"+
                "Тип коллекции: " + collection.getClass().toString();
    }
}

