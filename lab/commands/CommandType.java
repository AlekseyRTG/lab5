package lab.commands;

/**
 * Enum со всеми возмодными комаднами.
 */
public enum CommandType {
    HELP("help : вывести информацию о командах"),
    INFO("info : вывести информацию о коллекции"),
    SHOW("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении"),
    ADD("add id {element} : добавить новый элемент с заданным ключом"),
    UPDATE("update id {element} : обновить значение элемента коллекции, id которого равен заданному"),
    REMOVE_BY_ID("remove_by_id id : удалить элемент из коллекции по его ключу"),
    CLEAR("clear : очистить коллекцию"),
    SAVE("save : сохранить коллекцию в файл"),
    EXECUTE_SCRIPT("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме."),
    EXIT("exit : завершить программу (без сохранения в файл)"),
    ADD_IF_MIN("add_if_min {element}: Добавляет элемент , если он минимальный"),
    MAX_BY_ID("max_by_id: находит элемент максимальный по id"),
    PRINT_DESCENDING("print_descending: выводит список коллекции по убыванию цены"),
    REMOVE_LOWER("remove_lower {element}: удаляет элемент мельше заданного (по цене)");
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