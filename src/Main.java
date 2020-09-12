import java.util.*;
public class Main{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a command ");
        String command = in.nextLine();

        if (command == "help"){
            System.out.println("Доступные комманды");
        } else {
            System.out.println("Неизвестная команда");
        }

        in.close();
    }
}
