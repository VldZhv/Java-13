package ru.netology.todos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchQueryInSimpleTaskTitle() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        boolean result = simpleTask.matches("Позвонить");

        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotMatchQueryInSimpleTaskTitle() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        boolean result = simpleTask.matches("встреча");

        Assertions.assertFalse(result);
    }

    @Test
    public void epicShouldMatchQueryInSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        boolean result = epic.matches("Яйца");

        Assertions.assertTrue(result);
    }

    @Test
    public void epicShouldNotMatchQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        boolean result = epic.matches("Пиво");

        Assertions.assertFalse(result);
    }

    @Test
    public void meetingShouldMatchQueryInTopic() {
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean result = meeting.matches("Приложение");

        Assertions.assertTrue(result);
    }

    @Test
    public void meetingShouldMatchQueryInProject() {
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean result = meeting.matches("Выкатка");

        Assertions.assertTrue(result);
    }

    @Test
    public void meetingShouldNotMatchQuery() {
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean result = meeting.matches("вторник");

        Assertions.assertFalse(result);
    }
}