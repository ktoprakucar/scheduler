package algorithm;

import algorithm.aperiodic.EarliestDueDate;
import org.junit.Before;
import org.junit.Test;
import task.Aperiodic;

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

        Aperiodic task1 = new Aperiodic(1, 0, 2, 10);
        Aperiodic task2 = new Aperiodic(2, 0, 3, 9);
        Aperiodic task3 = new Aperiodic(3, 0, 4, 6);
        Aperiodic task4 = new Aperiodic(4, 0, 5, 5);
        task4.setDone();

        List<Aperiodic> tasks = new ArrayList();
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

        Aperiodic task1 = new Aperiodic(1, 0, 2, 10);
        Aperiodic task2 = new Aperiodic(2, 0, 3, 9);
        Aperiodic task3 = new Aperiodic(3, 0, 4, 6);
        Aperiodic task4 = new Aperiodic(4, 0, 5, 5);
        task3.setDone();
        task4.setDone();

        List<Aperiodic> tasks = new ArrayList();
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
        Aperiodic task1 = new Aperiodic(1, 0, 2, 10);
        Aperiodic task2 = new Aperiodic(2, 0, 3, 9);
        Aperiodic task3 = new Aperiodic(3, 0, 4, 16);
        Aperiodic task4 = new Aperiodic(4, 0, 5, 5);

        List<Aperiodic> tasks = new ArrayList();
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
        Aperiodic task1 = new Aperiodic(1, 0, 2, 10);
        Aperiodic task2 = new Aperiodic(2, 0, 3, 9);
        Aperiodic task3 = new Aperiodic(3, 0, 4, 16);
        Aperiodic task4 = new Aperiodic(4, 0, 5, 5);

        task1.setDone();
        task3.setDone();

        List<Aperiodic> tasks = new ArrayList();
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
        Aperiodic task1 = new Aperiodic(1, 0, 2, 10);
        Aperiodic task2 = new Aperiodic(2, 0, 3, 9);
        Aperiodic task3 = new Aperiodic(3, 0, 4, 16);
        Aperiodic task4 = new Aperiodic(4, 0, 5, 5);

        task1.setDone();
        task3.setDone();

        List<Aperiodic> tasks = new ArrayList();
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
        Aperiodic task = new Aperiodic(1, 0, 1, 10);

        //when
        earliestDueDate.runTask(task);

        //then
        assertEquals(task.getDuration(), 0);
        assertEquals(task.isDone(), true);
    }

    @Test
    public void should_decrease_duration_and_not_set_done(){
        //given
        Aperiodic task = new Aperiodic(1, 0, 4, 10);

        //when
        earliestDueDate.runTask(task);

        //then
        assertEquals(task.getDuration(), 3);
        assertEquals(task.isDone(), false);
    }
}
