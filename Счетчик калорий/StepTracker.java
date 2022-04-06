import java.util.HashMap;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    MonthData monthData;

    //метод ввода количества шагов за день
    public void countOfStepsOfDay() {
        numberOfMonth(); //человек выбирает месяц
        int command = scanner.nextInt();
        System.out.println("Введите за какой день месяца нужно сохранить результат");
        int dateOfDaySteps = scanner.nextInt();
        System.out.println("Введите количество шагов за этот день");
        int countOfSteps = scanner.nextInt();
    }


    public StepTracker() {
        for (int i = 0; i < 12; i++)
            monthToData.put(i, new MonthData());
    }

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
}
