package algorithm.aperiodic;

import org.junit.Test;
import task.Aperiodic;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EarliestDeadlineFirstTest {

    EarliestDeadlineFirst scheduler = new EarliestDeadlineFirst();

    @Test
    public void should_retrieve_earliest_due_date() {
        Aperiodic task1 = new Aperiodic(1, 0, 2, 10);
        Aperiodic task2 = new Aperiodic(2, 0, 3, 9);
        Aperiodic task3 = new Aperiodic(3, 0, 4, 9);
        Aperiodic task4 = new Aperiodic(4, 0, 5, 9);
        task3.setDone();

        List<Aperiodic> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        for (int i = 0; i < 99; i++) {
            Aperiodic earliestDuedateTask = scheduler.retrieveEarliestDueDate(tasks, i);
            System.out.println(earliestDuedateTask.getId());
            assertEquals(earliestDuedateTask.getDueDate(), 9);
            assertNotEquals(earliestDuedateTask.getId(), 1);
            assertNotEquals(earliestDuedateTask.getId(), 3);
        }
    }

    @Test
    public void should_schedule_earliest_deadline_first() {
        //given
        Aperiodic task1 = new Aperiodic(1, 0, 10, 33);
        Aperiodic task2 = new Aperiodic(2, 4, 3, 28);
        Aperiodic task3 = new Aperiodic(3, 5, 10, 29);

        List<Aperiodic> tasks = new ArrayList();
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