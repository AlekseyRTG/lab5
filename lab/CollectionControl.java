package lab;

import lab.collection.SpaceMarine;

import java.util.HashMap;

/**
 * Класс доступа к коллекции
 */
public class CollectionControl {
    FileManager fileManager = new FileManager();
    HashMap<Long, SpaceMarine> collection;
    public HashMap<Long, SpaceMarine> getCollection() {
        return collection;
    }

    /**
     * Загружает коллекцию из файла.
     * @param filePath Путь к файлу.
     * @return Успешность загрузки.
     */
    public boolean loadCollection(String filePath) {
        this.collection = fileManager.loadCollection(filePath);
        return collection != null;
    }

    /**
     * Хосраняет коллекцию в файл, из которого она была загружена.
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

