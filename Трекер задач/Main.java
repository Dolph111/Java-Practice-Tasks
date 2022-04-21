import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Task task;
        Epic epic;
        Subtask subtask;
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);

        //вызов меню
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                manager.newTask();
            } else if (command == 2) {
                //
            } else if (command == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет");
            }
        }
    }

    //Реализация меню
    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Создать задачу");
        System.out.println("2 - Получить список всех задач");
        System.out.println("3 - Удалить все задачи");
        System.out.println("4 - Получить задачу по номеру");
        System.out.println("5 - Обновить задачу");
        System.out.println("6 - Удалить задачу по номеру");
        System.out.println(("0 - Завершить работу"));
    }
}
