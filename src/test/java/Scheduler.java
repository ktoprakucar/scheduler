import algorithm.Algorithm;
import algorithm.aperiodic.EarliestDeadlineFirst;
import algorithm.aperiodic.EarliestDueDate;
import algorithm.aperiodic.LeastSlackTime;
import algorithm.periodic.RateMonotonic;
import entity.Task;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class Scheduler {

    Reader reader;
    List<Task> taskList;
    String fileName;

    //aperiodic algorithms
    Algorithm earliestDeadlineFirstAperiodic = new EarliestDeadlineFirst();
    Algorithm earliestDueDate = new EarliestDueDate();
    Algorithm leastSlackTime = new LeastSlackTime();

    //periodic algorithms
    Algorithm earliestDeadlineFirstPeriodic = new algorithm.periodic.EarliestDeadlineFirst();
    Algorithm rateMonotonic = new RateMonotonic();

    @Before
    public void setUp() throws IOException {
        fileName = "/Users/toprak.ucar/Desktop/embeddedSystems/scheduler/src/main/resources/tasks.txt";
        reader = new Reader();
        taskList = reader.read(fileName);
    }

    @Test
    public void should_schedule() throws IOException {
        boolean isPeriodic = taskList.get(0).isPeriodic();
        if(isPeriodic){
            System.out.println("-----------------EDF----------------------");
            boolean isEdfDone = earliestDeadlineFirstPeriodic.execute(taskList);
            if(isEdfDone){
                earliestDeadlineFirstPeriodic.printTasks();
            }else{
                System.out.println("it cannot be scheduled by edf");
            }
            taskList = reader.read(fileName);
            System.out.println("-----------------RM----------------------");
            boolean isRmDone = rateMonotonic.execute(taskList);
            if(isRmDone){
                rateMonotonic.printTasks();
            }else{
                System.out.println("it cannot be scheduled by rm");
            }
        } else{
            earliestDueDate.execute(taskList);
            earliestDeadlineFirstAperiodic.execute(taskList);
            leastSlackTime.execute(taskList);
        }
    }

    @Ignore
    @Test
    public void should_schedule_rate_monotonic(){
        rateMonotonic.execute(taskList);
        rateMonotonic.printTasks();
    }

    @Ignore
    @Test
    public void should_schedule_edf_periodic(){
        earliestDeadlineFirstPeriodic.execute(taskList);
        earliestDeadlineFirstPeriodic.printTasks();
    }
}
