package algorithm;

import algorithm.aperiodic.EarliestDueDate;
import org.junit.Before;
import org.junit.Test;
import task.Aperiodic;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EarliestDueDateTest {
    Algorithm earliestDueDate;

    @Before
    public void setUp() {
        earliestDueDate = new EarliestDueDate();
    }

    @Test
    public void should_execute_schedule(){
        //given
        Aperiodic task1 = new Aperiodic(1, 0, 2, 20);
        Aperiodic task2 = new Aperiodic(2, 0, 3, 19);
        Aperiodic task3 = new Aperiodic(3, 0, 4, 18);
        Aperiodic task4 = new Aperiodic(4, 0, 5, 17);

        List<Aperiodic> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        //when
        boolean isScheduled = earliestDueDate.execute(tasks);

        //then
        assertEquals(isScheduled, true);
        earliestDueDate.printTasks();
    }

    @Test
    public void should_not_execute_schedule(){
        //given
        Aperiodic task1 = new Aperiodic(1, 0, 2, 8);
        Aperiodic task2 = new Aperiodic(2, 0, 3, 7);
        Aperiodic task3 = new Aperiodic(3, 0, 4, 6);
        Aperiodic task4 = new Aperiodic(4, 0, 5, 5);

        List<Aperiodic> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        //when
        boolean isScheduled = earliestDueDate.execute(tasks);

        //then
        assertEquals(isScheduled, false);
        earliestDueDate.printTasks();
    }
}
