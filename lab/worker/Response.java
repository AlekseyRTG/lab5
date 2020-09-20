package lab.worker;

/**
 * Класс ответа программы на команду пользователя.
 */
public class Response {
    private final String msg;

    public Response(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}

