package algorithm.aperiodic;

import algorithm.Algorithm;
import org.junit.Before;
import org.junit.Test;
import entity.Task;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EarliestDueDateTest {
    Algorithm scheduler;

    @Before
    public void setUp() {
        scheduler = new EarliestDueDate();
    }

    @Test
    public void should_execute_schedule() {
        //given
        Task task1 = new Task(1, 0, 2, 20);
        Task task2 = new Task(2, 0, 3, 19);
        Task task3 = new Task(3, 0, 4, 18);
        Task task4 = new Task(4, 0, 5, 17);

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        //when
        boolean isScheduled = scheduler.execute(tasks);

        //then
        assertEquals(isScheduled, true);
        scheduler.printTasks();
    }

    @Test
    public void should_not_execute_schedule() {
        //given
        Task task1 = new Task(1, 0, 2, 8);
        Task task2 = new Task(2, 0, 3, 7);
        Task task3 = new Task(3, 0, 4, 6);
        Task task4 = new Task(4, 0, 5, 5);

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        //when
        boolean isScheduled = scheduler.execute(tasks);

        //then
        assertEquals(isScheduled, false);
        scheduler.printTasks();
    }
}
