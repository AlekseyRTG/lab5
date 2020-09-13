import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Commands {

    static void help(){
        System.out.println(" ");
        System.out.println("help : Вывести справку по доступным командам");
        System.out.println("info : Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количества элементов и т.д");
        System.out.println("show : Вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add {element} : Добавить новый элемент в коллекцию");
        System.out.println("update id {element} : Обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id *id* : Удалить элемент из коллекции по его id");
        System.out.println("clear : Очистить коллекцию");
        System.out.println("save : Сохранить коллекцию в файл");
        System.out.println("execute_script *file_name* : Считать и исполнить скрипт из указанного файла. В скрипте содержаться команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
        System.out.println("exit : Завершить программу (без сохранения в файл)");
        System.out.println("remove_head : Вывести первый элемент коллекции и удалить его");
        System.out.println("add_if_min {element} : Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        System.out.println("remove_lower {element} : Удалить из коллекции все элементы, меньшие чем заданный");
        System.out.println("max_by_id : Вывести любой объект из коллекции, значение поля id которого является максимальным");
        System.out.println("count_by_price *price* : Вывести количество элементов, значение поля price которых равно заданному");
        System.out.println("print_descending : Вывести элементы коллекции в порядке убывания");
        System.out.println(" ");

    }

    static void info(){
        String date;
        if(true){
            System.out.println(" ");
            System.out.println("Тип коллекции: ");
        }
    }
}

