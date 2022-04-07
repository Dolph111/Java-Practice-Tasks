import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    int dayStepGoal = 10000;
    HashMap<Integer, MonthData> monthToData;
    Scanner scanner = new Scanner(System.in);

    public StepTracker() {
        for (int i = 0; i < 12; i++)
            monthToData.put(i, new MonthData());
    }


    //метод ввода количества шагов за день
    public void countOfStepsOfDay() {
        numberOfMonth(); //человек выбирает месяц
        int month = scanner.nextInt(); //переменная месяц
        System.out.println("Введите за какой день месяца нужно сохранить результат");
        int dateOfDaySteps = scanner.nextInt(); //переменная день месяца
        System.out.println("Введите количество шагов за этот день");
        int countOfSteps = scanner.nextInt(); //переменная количество шагов
        saveResult(month, dateOfDaySteps, countOfSteps);


    }

    //метод выбор месяца
    public void numberOfMonth() {
        System.out.println("Выберите месяц");
        System.out.println("0 - Январь");
        System.out.println("1 - Февраль");
        System.out.println("2 - Март");
        System.out.println("3 - Апрель");
        System.out.println("4 - Май");
        System.out.println("5 - Июнь");
        System.out.println("6 - Июль");
        System.out.println("7 - Август");
        System.out.println("8 - Сентябрь");
        System.out.println("9 - Октябрь");
        System.out.println("10 - Ноябрь");
        System.out.println("11 - Декабрь");
    }

    //метод сохранения результата
    void saveResult(int month, int dateOfDaySteps, int countOfSteps) {
        for(Integer x: monthToData.keySet()) {
            if(x == month) { //нашли нужный месяц по ключу
                monthToData.get(x).addSteps(dateOfDaySteps, countOfSteps); //нашли нужный объект и вызвали метод для сохранения шагов
            }
        }
    }

    //расписали объект
    public class MonthData {
        int[] days; //создали список

    //шаблон объекта, т.е. заполняем его значениями
        public MonthData() {
            days = new int[30];
        }
        void addSteps(int day, int steps) { //метод для сохранения данных шагов за день
            days[day - 1] = steps;
        }

        int sumForMonth() {
            int sumStepsForMonth = 0;
            for(int i = 0; i < 30; i++) {

            }
        }

    }

    //метод вывода статистики шагов за месяц
    int printStatistic() {
        System.out.println("Выберите месяц, за который хотите увидеть статистику");
        numberOfMonth();
        int month = scanner.nextInt();
        for(Integer x: monthToData.keySet()) {
            if(x == month) {
                    monthToData.get(x).sumForMonth();
            }
        }
    }

}
