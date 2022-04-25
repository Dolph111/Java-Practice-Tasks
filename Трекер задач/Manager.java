package com.learning;

import com.learning.model.Epic;
import com.learning.model.Status;
import com.learning.model.Subtask;
import com.learning.model.Task;

import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, Task> storage = new HashMap<>();

    //метод создания задачи
    public void newTask() {
        Task task = new Task(); //создали объект задачу

        System.out.println("Введите название задачи");
        task.name = scanner.nextLine();
        System.out.println("Введите описание задачи");
        task.description = scanner.nextLine();

        task.status = Status.NEW;

        System.out.println("Есть ли у этой задачи какие-то подзадачи?");
        System.out.println("1 - есть подзадачи");
        System.out.println("2 - нет подзадач");
        int command2 = scanner.nextInt();
        scanner.nextLine(); //считать пустую строку после nextInt()
        if (command2 == 1) {
            Epic epic = new Epic(task); //передали в эпик задачу.
            addSubtask(epic);

            boolean hasMoreSubtasks = true;
            while (hasMoreSubtasks) {
                System.out.println("Добавить еще: 1 - да, 2 - нет");
                int newSubtask = scanner.nextInt();
                scanner.nextLine(); //считать пустую строку после nextInt()
                if (newSubtask == 1) {
                    addSubtask(epic);
                } else {
                    hasMoreSubtasks = false;
                }
            }

            int taskId = IdGenerator.nextId();
            storage.put(taskId, epic);
            System.out.println("New epic created with ID " + taskId + "\n" + epic);
        } else if (command2 == 2) {
            int taskId = IdGenerator.nextId();
            storage.put(taskId, task);
            System.out.println("New task created with ID " + taskId + "\n" + task);


        } else {
            System.out.println("Выбрана неверная команда");
        }

    }

    public void addSubtask(Epic epic) {
        Subtask task = new Subtask();
        System.out.println("Введите название подзадачи");
        task.name = scanner.nextLine();
        System.out.println("Введите описание подзадачи");
        task.description = scanner.nextLine();
        task.status = Status.NEW;
        epic.tasks.add(task);
    }

    //Метод вывода списка всех задач
    public void getTask() {
        System.out.println("Список всех задач: ");
        for (Integer key : storage.keySet()) {
            System.out.println(storage.get(key));
        }
    }

    //Метод удаления всех задач
    public void deleteAllTask() {
        storage.clear();
        System.out.println("Все задачи были удалены");
    }

    //Метод получения задачи по номеру
    public void getTaskForId() {
        System.out.println("Введите номер задачи");
        int idForTask = scanner.nextInt();
        scanner.nextLine(); //считать пустую строку после nextInt()
        for (Integer key: storage.keySet()) {
            if (idForTask == key) {
                System.out.println(storage.get(key));
            }
        }
    }

    //Метод удаления задачи по номеру
    public void deleteTaskForId() {
        System.out.println("Введите номер задачи");
        int idForTask = scanner.nextInt();
        scanner.nextLine(); //считать пустую строку после nextInt()
        for (Integer key: storage.keySet()) {
            if (idForTask == key) {
                System.out.println(storage.remove(key));
            }
        }
    }

    //Метод обновления задачи
    public void updateTasks() {
        Task task = new Task(); //создали новый объект задачу
        System.out.println("Выберите ID задачи, которую надо обновить");
        for (Integer key: storage.keySet()) {
            System.out.println(key + ": " + storage.get(key));
        }
        int idTaskForUpdate = scanner.nextInt();
        scanner.nextLine(); //считать пустую строку после nextInt()

    }

}
