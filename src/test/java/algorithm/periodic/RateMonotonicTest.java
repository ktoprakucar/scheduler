package algorithm.periodic;

import entity.Task;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RateMonotonicTest {

    RateMonotonic rateMonotonic = new RateMonotonic();

    @Test
    public void should_gcd_is_greater_than_one(){
        //given
        Task task1 = new Task(1, 0, 1, 2);
        Task task2 = new Task(2, 0, 2, 6);
        Task task3 = new Task(3, 0, 1, 6);

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        //when
        boolean isScheduled = rateMonotonic.checkUtilisationValue(tasks);

        //then
        assertTrue(isScheduled);
    }

    @Test
    public void should_gcd_is_one_and_utilization_is_not_okay(){
        //given
        Task task1 = new Task(1, 0, 1, 2);
        Task task2 = new Task(2, 0, 2, 6);
        Task task3 = new Task(3, 0, 2, 5);

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        //when
        boolean isScheduled = rateMonotonic.checkUtilisationValue(tasks);

        //then
        assertFalse(isScheduled);
    }

    @Test
    public void should_retrieve_the_highest_priority(){
        //given
        Task task1 = new Task(1, 0, 1, 2);
        Task task2 = new Task(2, 0, 2, 6);
        Task task3 = new Task(3, 0, 2, 6);
        Task task4 = new Task(4, 0, 2, 2);

        task1.setPeriodic();
        task2.setPeriodic();
        task3.setPeriodic();
        task4.setPeriodic();

        List<Task> tasks = new ArrayList();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        //when
        for(int i = 0; i < 99; i++){
            Task task = rateMonotonic.retrieveHighestPriority(tasks, 0);
            assertEquals(task.getPeriod(), 2);
            assertNotEquals(task.getId(), 2);
            assertNotEquals(task.getId(), 3);
        }
    }


}