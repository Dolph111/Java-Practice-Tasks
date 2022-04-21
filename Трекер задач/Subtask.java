//Каждая подзадача знает в рамках какого эпика она выполняется
//Завершение всех подзадач является завершением эпика

public class Subtask extends Epic {

    public Subtask(String name, String description, String status) {
        super(name, description, status);
    }
}
