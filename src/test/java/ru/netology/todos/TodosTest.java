package ru.netology.todos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {


    @Test
    public void shouldSearchTaskSingle() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTasksMulti() {
        SimpleTask task1 = new SimpleTask(1, "позвонить родителям");
        SimpleTask task2 = new SimpleTask(2, "купить яйца");
        Epic epic = new Epic(3, new String[]{"молоко", "яйца", "хлеб"});
        Meeting meeting1 = new Meeting(4, "выкатка 3й версии приложения", "приложение НетоБанка", "во вторник после обеда");
        Meeting meeting2 = new Meeting(5, "как сварить яйца", "приложение \"Юный кулинар\"", "в среду после обеда");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(epic);
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = {task2, epic, meeting2};
        Task[] actual = todos.search("яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothing() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Пиво");
        Assertions.assertArrayEquals(expected, actual);
    }
//     @Test
//      public void shouldAddThreeTasksOfDifferentType() {
//          SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
//
//          String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
//          Epic epic = new Epic(55, subtasks);
//
//          Meeting meeting = new Meeting(
//                  555,
//                  "Выкатка 3й версии приложения",
//                  "Приложение НетоБанка",
//                  "Во вторник после обеда"
//          );
//
//          Todos todos = new Todos();
//
//          todos.add(simpleTask);
//          todos.add(epic);
//          todos.add(meeting);
//
//          Task[] expected = {simpleTask, epic, meeting};
//          Task[] actual = todos.findAll();
//          Assertions.assertArrayEquals(expected, actual);
//      }
//
//
//
//      @Test
//      public void shouldSearchTasksMeetings() {
//          SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
//          Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
//          Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
//
//          Todos todos = new Todos();
//          todos.add(simpleTask);
//          todos.add(epic);
//          todos.add(meeting);
//
//          Task[] expected = {meeting};
//          Task[] actual = todos.search("Приложение");
//          Assertions.assertArrayEquals(expected, actual);
//      }
//
//      @Test
//      public void shouldSearchTasksEpic() {
//          SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
//          Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
//          Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
//
//          Todos todos = new Todos();
//          todos.add(simpleTask);
//          todos.add(epic);
//          todos.add(meeting);
//
//          Task[] expected = {epic};
//          Task[] actual = todos.search("Яйца");
//          Assertions.assertArrayEquals(expected, actual);
//      }


}

