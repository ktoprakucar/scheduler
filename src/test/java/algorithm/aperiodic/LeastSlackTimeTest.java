package algorithm.aperiodic;

import org.junit.Test;
import entity.Task;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LeastSlackTimeTest {

    LeastSlackTime scheduler = new LeastSlackTime();

    @Test
    public void should_calculate_slack_time() {
        //given
        Task task = new Task(1, 0, 10, 33);
        int timeUnit = 5;

        //when
        int slackTime = scheduler.calculateSlackTime(task, timeUnit);

        //then
        assertEquals(slackTime, 18);
    }

    @Test
    public void should_retrieve_least_slack_time() {
        //given
        int timeUnit = 2;

        Task task1 = new Task(1, 0, 10, 33);
        Task task2 = new Task(2, 1, 3, 28);
        Task task3 = new Task(3, 2, 10, 29);

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        //when
        Task leastSlackTimeTask = scheduler.retrieveLeastSlackTimeTask(tasks, timeUnit);

        //then
        assertEquals(leastSlackTimeTask.getId(), 3);
    }

    @Test
    public void should_retrieve_least_slack_time_when_two_of_them_are_same() {
        //given
        int timeUnit = 2;

        Task task1 = new Task(1, 0, 10, 33);
        Task task2 = new Task(2, 1, 3, 28);
        Task task3 = new Task(3, 2, 10, 33);
        Task task4 = new Task(4, 2, 10, 33);

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        //when and then
        for (int i = 0; i < 99; i++) {
            Task leastSlackTimeTask = scheduler.retrieveLeastSlackTimeTask(tasks, timeUnit);
            assertNotEquals(leastSlackTimeTask.getId(), 2);
        }
    }

    @Test
    public void should_schedule_least_slack_time() {
        //given
        Task task1 = new Task(1, 0, 10, 33);
        Task task2 = new Task(2, 4, 3, 28);
        Task task3 = new Task(3, 5, 10, 29);

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        //when
        boolean isScheduled = scheduler.execute(tasks);

        //then
        assertTrue(isScheduled);
        scheduler.printTasks();
    }
}