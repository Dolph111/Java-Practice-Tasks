import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, Object> map = new HashMap<>();
    int id = 1;


    //метод создания задачи
    public void newTask() {
        System.out.println("Введите название задачи");
        String nameTask = scanner.nextLine();
        System.out.println("Введите описание задачи");
        String descriptionTask = scanner.nextLine();

        System.out.println("Есть ли у этой задачи какие-то подзадачи?");
        System.out.println("1 - есть подзадачи");
        System.out.println("2 - нет подзадач");
        int command2 = scanner.nextInt();
        if (command2 == 1) {
            System.out.println("Укажите все подзадачи");
            while (scanner.hasNext()) {
             //будет перечисление подзадач
            }
            map.put(id, new Epic(nameTask, descriptionTask, "New"));

        } else if (command2 == 2) {
            map.put(id, new Task(nameTask, descriptionTask, "New"));
            id++;
        } else {
            System.out.println("Выбрана неверная команда");
        }
    }
}
