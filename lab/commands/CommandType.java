package lab.commands;

/**
 * Enum со всеми возмодными комаднами.
 */
public enum CommandType {
    HELP("help : вывести справку по доступным командам"),
    INFO("info : вывести информацию о коллекции"),
    SHOW("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении"),
    INSERT("insert key(id) {element} : добавить новый элемент с заданным ключом"),
    UPDATE("update key(id) {element} : обновить значение элемента коллекции, id которого равен заданному"),
    REMOVE_KEY("remove_key key(id) : удалить элемент из коллекции по его ключу"),
    CLEAR("clear : очистить коллекцию"),
    SAVE("save : сохранить коллекцию в файл"),
    EXECUTE_SCRIPT("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме."),
    EXIT("exit : завершить программу (без сохранения в файл)"),
    HISTORY("history : вывести последние 7 команд (без их аргументов)"),
    REPLACE_IF_LOWE("replace_if_lowe key(id) {element} : заменить значение по ключу, если новое значение меньше старого"),
    REMOVE_GREATER_KEY("remove_greater_key key(id) : удалить из коллекции все элементы, ключ которых превышает заданный"),
    GROUP_COUNTING_BY_CREATION_DATE("group_counting_by_creation_date : сгруппировать элементы коллекции по значению поля creationDate, вывести количество элементов в каждой группе"),
    PRINT_ASCENDING("print_ascending : вывести элементы коллекции в порядке возрастания"),
    PRINT_FIELD_DESCENDING_MELEE_WEAPON("print_field_descending_melee_weapon : вывести значения поля meleeWeapon всех элементов в порядке убывания");
    String help;

    CommandType(String help) {
        this.help = help;
    }

    /**
     * Вохвращает подсказку по команде.
     * @return Подсказка по команде.
     */
    public String getHelp() {
        return help;
    }
}