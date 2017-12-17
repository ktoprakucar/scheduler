package algorithm;

import algorithm.aperiodic.EarliestDueDate;
import org.junit.Before;
import org.junit.Test;
import entity.Task;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AlgorithmTest {
    Algorithm earliestDueDate;

    @Before
    public void setUp() {
        earliestDueDate = new EarliestDueDate();
    }

    @Test
    public void should_exceed_due_date(){
        //given
        earliestDueDate.increaseTimeUnit();
        earliestDueDate.increaseTimeUnit();
        earliestDueDate.increaseTimeUnit();
        earliestDueDate.increaseTimeUnit();
        earliestDueDate.increaseTimeUnit();
        earliestDueDate.increaseTimeUnit();
        earliestDueDate.increaseTimeUnit();

        Task task1 = new Task(1, 0, 2, 10);
        Task task2 = new Task(2, 0, 3, 9);
        Task task3 = new Task(3, 0, 4, 6);
        Task task4 = new Task(4, 0, 5, 5);
        task4.setDone();

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        //when
        boolean isExceeded = earliestDueDate.isDueDateExceeded(tasks);

        //then
        assertEquals(isExceeded, true);
    }

    @Test
    public void should_not_exceed_due_date(){
        //given
        earliestDueDate.increaseTimeUnit();
        earliestDueDate.increaseTimeUnit();
        earliestDueDate.increaseTimeUnit();
        earliestDueDate.increaseTimeUnit();
        earliestDueDate.increaseTimeUnit();
        earliestDueDate.increaseTimeUnit();
        earliestDueDate.increaseTimeUnit();

        Task task1 = new Task(1, 0, 2, 10);
        Task task2 = new Task(2, 0, 3, 9);
        Task task3 = new Task(3, 0, 4, 6);
        Task task4 = new Task(4, 0, 5, 5);
        task3.setDone();
        task4.setDone();

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        //when
        boolean isExceeded = earliestDueDate.isDueDateExceeded(tasks);

        //then
        assertEquals(isExceeded, false);
    }

    @Test
    public void should_retrieve_latest_due_date_when_all_tasks_are_non_done(){
        //given
        Task task1 = new Task(1, 0, 2, 10);
        Task task2 = new Task(2, 0, 3, 9);
        Task task3 = new Task(3, 0, 4, 16);
        Task task4 = new Task(4, 0, 5, 5);

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        //when
        int latestDueDate = earliestDueDate.retrieveLatestDueDate(tasks);

        //then
        assertEquals(latestDueDate, 16);
    }

    @Test
    public void should_retrieve_latest_due_date_when_some_tasks_are__done(){
        //given
        Task task1 = new Task(1, 0, 2, 10);
        Task task2 = new Task(2, 0, 3, 9);
        Task task3 = new Task(3, 0, 4, 16);
        Task task4 = new Task(4, 0, 5, 5);

        task1.setDone();
        task3.setDone();

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        //when
        int latestDueDate = earliestDueDate.retrieveLatestDueDate(tasks);

        //then
        assertEquals(latestDueDate, 9);
    }

    @Test
    public void should_retrieve_sum_of_durations(){
        //given
        Task task1 = new Task(1, 0, 2, 10);
        Task task2 = new Task(2, 0, 3, 9);
        Task task3 = new Task(3, 0, 4, 16);
        Task task4 = new Task(4, 0, 5, 5);

        task1.setDone();
        task3.setDone();

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        //when
        int latestDueDate = earliestDueDate.retrieveSumOfDurations(tasks);

        //then
        assertEquals(latestDueDate, 14);
    }

    @Test
    public void should_decrease_duration_and_set_done(){
        //given
        Task task = new Task(1, 0, 1, 10);

        //when
        earliestDueDate.runTask(task);

        //then
        assertEquals(task.getDuration(), 0);
        assertEquals(task.isDone(), true);
    }

    @Test
    public void should_decrease_duration_and_not_set_done(){
        //given
        Task task = new Task(1, 0, 4, 10);

        //when
        earliestDueDate.runTask(task);

        //then
        assertEquals(task.getDuration(), 3);
        assertEquals(task.isDone(), false);
    }
}
