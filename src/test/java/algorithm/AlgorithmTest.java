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
}
