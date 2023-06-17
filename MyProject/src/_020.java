import java.util.LinkedList;
import java.util.Scanner;

public class _020 {

    public _020() {
        LinkedList<String> linkedList = new LinkedList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Введите строку (или print~num для вывода и удаления строки, exit для выхода): ");
                String input = scanner.nextLine();

                if (input.startsWith("print~")) {
                    int position = Integer.parseInt(input.substring(6));
                    if (position >= 0 && position < linkedList.size()) {
                        String str = linkedList.get(position);
                        System.out.println("Вывод строки: " + str);
                        linkedList.remove(position);
                    } else {
                        System.out.println("Ошибка: недопустимая позиция");
                    }
                } else if (input.equals("exit")) {
                    break;
                } else {
                    linkedList.add(input);
                }
            }
        } catch (NumberFormatException e) {
            
            e.printStackTrace();
        }

        System.out.println("Завершение работы программы");
    }
}