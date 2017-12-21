package algorithm.periodic;

import entity.Task;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EarliestDeadlineFirstTest {

    EarliestDeadlineFirst earliestDeadlineFirst = new EarliestDeadlineFirst();

    @Test
    public void retrieve_earliest_deadline(){
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
            Task task = earliestDeadlineFirst.retrieveEarliestDueDate(tasks, 0);
            assertEquals(task.getPeriod(), 2);
            assertNotEquals(task.getId(), 2);
            assertNotEquals(task.getId(), 3);
        }
    }
}