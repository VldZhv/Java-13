import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTasksSimple() {
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
    public void shouldSearchTasksMeetings() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTasksEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyIfNoMatch() {
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
}

