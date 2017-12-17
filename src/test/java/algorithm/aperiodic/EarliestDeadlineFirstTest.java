package algorithm.aperiodic;

import org.junit.Test;
import entity.Task;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EarliestDeadlineFirstTest {

    EarliestDeadlineFirst scheduler = new EarliestDeadlineFirst();

    @Test
    public void should_retrieve_earliest_due_date() {
        Task task1 = new Task(1, 0, 2, 10);
        Task task2 = new Task(2, 0, 3, 9);
        Task task3 = new Task(3, 0, 4, 9);
        Task task4 = new Task(4, 0, 5, 9);
        task3.setDone();

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        for (int i = 0; i < 99; i++) {
            Task earliestDuedateTask = scheduler.retrieveEarliestDueDate(tasks, i);
            System.out.println(earliestDuedateTask.getId());
            assertEquals(earliestDuedateTask.getDueDate(), 9);
            assertNotEquals(earliestDuedateTask.getId(), 1);
            assertNotEquals(earliestDuedateTask.getId(), 3);
        }
    }

    @Test
    public void should_schedule_earliest_deadline_first() {
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