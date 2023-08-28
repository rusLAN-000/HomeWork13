package ru.netology.stats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TasksTest {
    Todos todos = new Todos();
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void matchesSimpleTask() {
        boolean expected = simpleTask.matches("родителям");
        boolean actual = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notMatchesSimpleTask() {
        boolean expected = simpleTask.matches("Набрать");
        boolean actual = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesEpic() {
        boolean expected = epic.matches("Хлеб");
        boolean actual = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notMatchesEpic() {
        boolean expected = epic.matches("Банан");
        boolean actual = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeeting() {
        boolean expected = meeting.matches("версии");
        boolean actual = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notMatchesMeeting1() {
        boolean expected = meeting.matches("НеоБанка");
        boolean actual = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void notMatchesMeeting2() {
        boolean expected = meeting.matches("НетоБанка");
        boolean actual = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getId() {
        int expected = 5;
        int actual = simpleTask.getId();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void getTitle() {
        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void getSubtasks() {
        String[] expected = {"Молоко", "Яйца", "Хлеб"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void getMeetingTopic() {
        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void getMeetingProject() {
        String expected = "Приложение НетоБанка";
        String actual = meeting.getProject();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getMeetingStart() {
        String expected = "Во вторник после обеда";
        String actual = meeting.getStart();
        Assertions.assertEquals(expected,actual);
    }

}