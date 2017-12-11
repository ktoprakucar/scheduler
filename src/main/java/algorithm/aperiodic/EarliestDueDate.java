package algorithm.aperiodic;

import algorithm.Algorithm;
import task.Aperiodic;

import java.util.Comparator;
import java.util.List;

public class EarliestDueDate extends Algorithm {

    @Override
    public boolean execute(List<Aperiodic> tasks) {
        tasks.sort(Comparator.comparingInt(Aperiodic::getDueDate));
        for (Aperiodic task : tasks) {
            for (int i = 0; i < task.getDuration();task.decrease()) {
                schedule.add(task.getId());
                increaseTimeUnit();
                if (isDueDateExceeded(tasks)) {
                    return false;
                }
            }
            task.setDone();
        }
        return true;
    }

}
