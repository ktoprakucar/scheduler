package algorithm.aperiodic;

import algorithm.Algorithm;
import entity.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EarliestDeadlineFirst extends Algorithm {

    List<Task> uninitializedTasks = new ArrayList();

    @Override
    public boolean execute(List<Task> tasks) {
        uninitializedTasks.addAll(tasks);
        int sumOfDurations = retrieveSumOfDurations(uninitializedTasks);
        for (int i = 0; i < sumOfDurations; i++) {
            Task task = retrieveEarliestDueDate(uninitializedTasks, i);
            schedule.add(task.getId());
            runTask(task);
            increaseTimeUnit();
            if (isDueDateExceeded(uninitializedTasks)) {
                return false;
            }
        }
        return true;
    }

    public Task retrieveEarliestDueDate(List<Task> tasks, int timeUnit) {
        Random randomGenerator = new Random();
        Task earliestDueDateTask = tasks
                .stream()
                .filter(p-> p.getArrivalTime() <= timeUnit)
                .filter(p -> !p.isDone())
                .min(Comparator.comparing(Task::getDueDate))
                .get();

        int earliestDueDate = earliestDueDateTask.getDueDate();

        List<Task> earliestDueDateTasks = tasks
                .stream()
                .filter(p -> !p.isDone())
                .filter(p-> p.getArrivalTime() <= timeUnit)
                .filter(p -> p.getDueDate() == earliestDueDate)
                .collect(Collectors.toList());

        int index = randomGenerator.nextInt(earliestDueDateTasks.size());
        return earliestDueDateTasks.get(index);
    }
}
