import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(); //создали класс StepTracker

        while (true) {
            printMenu(); //вызвали меню
            int command = scanner.nextInt(); //выбрали команду
            if (command == 1) {
                stepTracker.countOfStepsOfDay(); //вызов метода ввода количества шагов за день
            } else if (command == 2) {
                System.out.println("Введите новую цель по шагам");
                int newTargetOfSteps = scanner.nextInt();
                stepTracker.newTargetOfSteps(newTargetOfSteps); //вызов метода изменения цели по шагам
                System.out.println("Новая цель по шагам сохранена");
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }


    // реализация меню
    private static void printMenu() {
                System.out.println("Что вы хотите сделать? ");
                System.out.println("1 - Ввести количество пройденных шагов за день");
                System.out.println("2 - Изменить цель по шагам в день");
                System.out.println("3 - Вывод статистики шагов за месяц");
                System.out.println("0 - Выход");
            }


}
