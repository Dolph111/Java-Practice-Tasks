import java.util.ArrayList;
import java.util.HashMap;

public class MonthData {
    HashMap<ArrayList<Integer>, Integer> dataToSteps = new HashMap<>();
    ArrayList<Integer> array = new ArrayList();
    for(int i = 0; i < 31; i++) {
        array.add(i+1);
    }

    public MonthData() {
        for (int i = 0; i < 30; i++) {
            dataToSteps.put(i, 0);
        }
    }
}
