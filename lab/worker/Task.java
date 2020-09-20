package lab.worker;

import lab.commands.CommandType;

/**
 * Класс задания программе.
 * @param <T> Первый аргумент .
 * @param <P> Второй аргумент.
 */
public class Task<T, P> {
    private CommandType type;
    private T firstArgument;
    private P secondArgument;

    public Task(CommandType type) {
        this.type = type;
    }

    public Task(CommandType type, T firstArgument) {
        this.type = type;
        this.firstArgument = firstArgument;
    }

    public Task(CommandType type, T firstArgument, P secondArgument) {
        this.type = type;
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }

    public T getFirstArgument() {
        return firstArgument;
    }

    public P getSecondArgument() {
        return secondArgument;
    }

    public CommandType getType() {
        return type;
    }
}
