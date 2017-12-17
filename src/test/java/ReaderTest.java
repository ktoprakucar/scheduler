import entity.Task;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class ReaderTest {

    Reader reader = new Reader();

    @Test
    public void should_create_tasks_from_file() throws IOException {
        //when
        List<Task> taskList = reader.read("/home/toprak/projects/java/scheduler/src/main/resources/tasks.txt");

        //then
        assertEquals(taskList.size(), 4);

        Task task = taskList.get(0);

        assertEquals(task.getId(), 1);
        assertEquals(task.isPeriodic(), false);
        assertEquals(task.getArrivalTime(), 1);
        assertEquals(task.getDuration(), 2);
        assertEquals(task.getDueDate(), 3);

        task = taskList.get(1);

        assertEquals(task.getId(), 2);
        assertEquals(task.isPeriodic(), false);
        assertEquals(task.getArrivalTime(), 1);
        assertEquals(task.getDuration(), 2);
        assertEquals(task.getDueDate(), 4);

        task = taskList.get(2);

        assertEquals(task.getId(), 3);
        assertEquals(task.isPeriodic(), false);
        assertEquals(task.getArrivalTime(), 0);
        assertEquals(task.getDuration(), 1);
        assertEquals(task.getDueDate(), 5);

        task = taskList.get(3);

        assertEquals(task.getId(), 4);
        assertEquals(task.isPeriodic(), false);
        assertEquals(task.getArrivalTime(), 2);
        assertEquals(task.getDuration(), 1);
        assertEquals(task.getDueDate(), 8);
    }

}