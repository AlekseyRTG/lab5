package lab;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lab.collection.SpaceMarine;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class FileManager {
    File collectionFile;

    /**
     * Загружает поллекцию из файла, указанного в аргументе.
     * @param filePath Путь к файлу коллекции.
     * @return Коллекция.
     */
    public HashMap<Long, SpaceMarine> loadCollection(String filePath) {
        HashMap<Long, SpaceMarine> collection = new HashMap<Long, SpaceMarine>();
        if (!setFile(filePath)) return null;
        else try (BufferedReader bufferedReader = new BufferedReader(new FileReader(collectionFile))) {
            Gson gson = new Gson();
            System.out.println("Загрузка коллекции из файла " + collectionFile.getAbsolutePath());
            StringBuilder stringBuilder = new StringBuilder();
            String nextString;
            while ((nextString = bufferedReader.readLine()) != null) {
                stringBuilder.append(nextString);
            }

            Type typeOfCollection = new TypeToken<HashMap<Long, SpaceMarine>>() {
            }.getType();
            try {
                HashMap<Long, SpaceMarine> addCollection = gson.fromJson(stringBuilder.toString(), typeOfCollection);
                if (addCollection != null)
                    for (Map.Entry<Long, SpaceMarine> set : addCollection.entrySet()) {
//                    if (spaceMarine.checkNull()) {
//                        throw new JsonSyntaxException("");
//                    }
                        collection.put(set.getKey(), set.getValue());
                    }
            } catch (JsonSyntaxException e) {
                System.out.println("Ошибка синтаксиса Json. Файл не может быть загружен.");
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Непредвиденная ошибка при считывании файла.");
                return null;
            }
            System.out.println("Коллекций успешно загружена. Добавлено " + collection.size() + " элементов.");
        } catch (IOException e) {
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
        File jsonPath = new File(path);
        if (jsonPath.exists()) {
            setCollectionFile(jsonPath);
            System.out.println("Path " + path + " discovered.");
        } else {
            System.out.println("Path " + path + " does not exist.");
            try {
                System.out.println("Create a new file.");
                if (jsonPath.createNewFile()) {
                    System.out.println("File not created");
                }
                setCollectionFile(jsonPath);
                save(new HashMap<>());
            } catch (IOException e) {
                System.out.println("Error creating file!!!");
                return false;
            }
        }
        if (!jsonPath.isFile()) {
            System.out.println("Path " + path + " does not contain a file name.");
            return false;
        } else {
            System.out.println("File " + path + " discovered.");
        }
        if (!(path.lastIndexOf(".json") == path.length() - 5)) {
            System.out.println("Non .json file format.");
            return false;
        }
        return true;
    }

    /**
     * Сохраняет коллекцию в файл.
     * @param collection Коллекция.
     * @return Успешность операции сохранения.
     */
    public boolean save(HashMap<Long, SpaceMarine> collection) {
        Gson gson = new Gson();
        if (!collectionFile.exists()) {
            System.out.println(("Невозможно сохранить файл. Файл по указанному пути (" + collectionFile.getAbsolutePath() + ") не существует."));
        } else if (!collectionFile.canRead() || !collectionFile.canWrite()) {
            System.out.println("Невозможно сохранить файл. Файл защищён от чтения и(или) записи.");
        } else {
            try (FileWriter fileWriter = new FileWriter(collectionFile)) {
                fileWriter.write(gson.toJson(collection));
                fileWriter.flush();
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

