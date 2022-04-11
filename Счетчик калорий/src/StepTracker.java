import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    int dayStepGoal = 10000;
    HashMap<Integer, MonthData> monthToData = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();

    public StepTracker() {
        for (int i = 0; i < 12; i++)
            monthToData.put(i, new MonthData());
    }

    //метод ввода количества шагов за день
    public void countOfStepsOfDay() {
        int month = 0;
        int dateOfDaySteps = 0;
        int countOfSteps = 0;

        while(true) {
            numberOfMonth(); //человек выбирает месяц
            month = scanner.nextInt(); //переменная месяц
            if (month > 0 && month < 12) {
                break;
            } else {
                System.out.println("Выбранного месяца не сущетсвует");
                System.out.println("Пожалуйста, выберите корректный месяц" + "\n");
            }
        }

        while (true) {
            System.out.println("Введите за какой день месяца нужно сохранить результат");
            dateOfDaySteps = scanner.nextInt(); //переменная день месяца
            if (dateOfDaySteps > 0 && dateOfDaySteps < 31 ) {
                break;
            } else {
                System.out.println("Такого дня в месяце не существует");
                System.out.println("Пожалуйста, введите существующий день месяца" + "\n");
            }
        }

        while (true) {
            System.out.println("Введите количество шагов за этот день");
            countOfSteps = scanner.nextInt(); //переменная количество шагов
            if (countOfSteps > 0) {
                break;
            } else {
                System.out.println("Неверное количество шагов");
                System.out.println("Пожалуйста, повторите ввод" + "\n");
            }
        }
        saveResult(month, dateOfDaySteps, countOfSteps); //метод сохранения результатов
        System.out.println("Значения сохранены");

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

    //расписали класс MonthData
    public class MonthData {
        int[] days; //создали список

    //шаблон объекта, т.е. заполняем его значениями
        public MonthData() {
            days = new int[30];
        }

        void addSteps(int day, int steps) { //метод для сохранения данных шагов за день
            days[day - 1] = steps;
        }

        void sumForMonth(MonthData x) { //метод принимает объёкт и находит сумму шагов у этого объекта
            int maxOfSteps = 0;
            int sumStepsForMonth = 0;
            int bestLine = 0;
            int middleLine = 0;
            for(int i = 0; i < 30; i++) {
                System.out.println("За " + (i+1) + " день пройдено:" + days[i]); //вывод шагов за каждый день
                if(days[i] >= maxOfSteps) {
                    maxOfSteps = days[i]; //подсчёт максимума шагов за день
                    if (days[i] < days[i+1] && i != 29 ||  i == 29 && days[i] > days[i-1] ) {
                        middleLine += 1;
                    } else {
                        if (middleLine >= bestLine) {
                        bestLine = middleLine;
                        middleLine = 0;
                        } else {
                            middleLine = 0;
                        }
                    }
                }
                sumStepsForMonth += days[i];
            }
            int middleofSteps = sumStepsForMonth / 30;
            System.out.println("За выбранный месяц вы прошли " + sumStepsForMonth + " шагов"); //вывод шагов за мес
            System.out.println("Максимальное пройденное количество шагов в месяце - " + maxOfSteps); //вывод макс. шагов за день в месяце
            System.out.println("Среднее количество шагов - " + middleofSteps); //среднее количество шагов
            System.out.println("Пройденная дистанция - " + converter.convertToKm(sumStepsForMonth) + " км");
            System.out.println("Количество сожженных килокалорий - " + converter.convertToKK(sumStepsForMonth));
            System.out.println("Лучшая серия - " + bestLine + "\n");
        }

    }

    //метод вывода статистики шагов за месяц
    void printStatistic() {
        System.out.println("Выберите месяц, за который хотите увидеть статистику");
        numberOfMonth();
        int month = scanner.nextInt();
        for(Integer x: monthToData.keySet()) {
            if(x == month) {
                monthToData.get(x).sumForMonth(monthToData.get(x));
            }
        }
    }
    //метод ввода новой цели по шагам
    void newTargetOfSteps(int newSteps) {
        dayStepGoal = newSteps;
    }

}
