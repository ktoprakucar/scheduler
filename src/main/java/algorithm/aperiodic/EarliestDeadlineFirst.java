package algorithm.aperiodic;

import algorithm.Algorithm;
import task.Aperiodic;

import java.util.ArrayList;
import java.util.List;

public class EarliestDeadlineFirst extends Algorithm {

    List<Aperiodic> uninitializedTasks = new ArrayList();

    @Override
    public boolean execute(List<Aperiodic> tasks) {
        uninitializedTasks.addAll(tasks);

        return false;
    }
}
