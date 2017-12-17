package algorithm.aperiodic;

import algorithm.Algorithm;
import task.Aperiodic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EarliestDeadlineFirst extends Algorithm {

    List<Aperiodic> uninitializedTasks = new ArrayList();

    @Override
    public boolean execute(List<Aperiodic> tasks) {
        uninitializedTasks.addAll(tasks);
        int sumOfDurations = retrieveSumOfDurations(uninitializedTasks);
        for (int i = 0; i < sumOfDurations; i++) {
            Aperiodic task = retrieveEarliestDueDate(uninitializedTasks, i);
            schedule.add(task.getId());
            runTask(task);
            increaseTimeUnit();
            if (isDueDateExceeded(uninitializedTasks)) {
                return false;
            }
        }
        return true;
    }

    public Aperiodic retrieveEarliestDueDate(List<Aperiodic> tasks, int timeUnit) {
        Random randomGenerator = new Random();
        Aperiodic earliestDueDateTask = tasks
                .stream()
                .filter(p-> p.getArrivalTime() <= timeUnit)
                .filter(p -> !p.isDone())
                .min(Comparator.comparing(Aperiodic::getDueDate))
                .get();

        int earliestDueDate = earliestDueDateTask.getDueDate();

        List<Aperiodic> earliestDueDateTasks = tasks
                .stream()
                .filter(p -> !p.isDone())
                .filter(p-> p.getArrivalTime() <= timeUnit)
                .filter(p -> p.getDueDate() == earliestDueDate)
                .collect(Collectors.toList());

        int index = randomGenerator.nextInt(earliestDueDateTasks.size());
        return earliestDueDateTasks.get(index);
    }
}
