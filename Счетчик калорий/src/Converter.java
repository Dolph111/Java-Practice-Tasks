public class Converter {
    int oneOfStepsInKm = 75;
    int oneOfStepsInKk = 50;

    public int convertToKm(int sumStepsForMonth) {
        double distance = sumStepsForMonth * oneOfStepsInKm * 0.000010;
        int result = (int) distance;
        return result;
    }

    public int convertToKK(int sumStepsForMonth) {
        double KK = sumStepsForMonth * oneOfStepsInKk * 0.001;
        int result = (int) KK;
        return result;
    }

}
