package algorithm.aperiodic;

import algorithm.Algorithm;
import entity.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LeastSlackTime extends Algorithm {

    List<Task> uninitializedTasks = new ArrayList();

    @Override
    public boolean execute(List<Task> tasks) {
        uninitializedTasks.addAll(tasks);
        int sumOfDurations = retrieveSumOfDurations(uninitializedTasks);

        for (int i = 0; i < sumOfDurations; i++) {
            Task task = retrieveLeastSlackTimeTask(uninitializedTasks, i);
            schedule.add(task.getId());
            runTask(task);
            increaseTimeUnit();
            if (isDueDateExceeded(uninitializedTasks)) {
                return false;
            }
        }
        return true;
    }

    public Task retrieveLeastSlackTimeTask(List<Task> tasks, int timeUnit) {
        Random randomGenerator = new Random();
        Task leastSlackTimeTask = tasks
                .stream()
                .filter(p -> p.getArrivalTime() <= timeUnit)
                .filter(p -> !p.isDone())
                .min(Comparator.comparing(p -> calculateSlackTime(p, timeUnit)))
                .get();

        int leastSlackTime = calculateSlackTime(leastSlackTimeTask, timeUnit);

        List<Task> leastSlackTimeTasks = tasks
                .stream()
                .filter(p -> p.getArrivalTime() <= timeUnit)
                .filter(p -> !p.isDone())
                .filter(p -> calculateSlackTime(p, timeUnit) == leastSlackTime)
                .collect(Collectors.toList());

        int index = randomGenerator.nextInt(leastSlackTimeTasks.size());
        return leastSlackTimeTasks.get(index);
    }

    public int calculateSlackTime(Task task, int timeUnit) {
        int dueDate = task.getDueDate();
        int durationLeft = task.getDuration();
        int slackTime = dueDate - timeUnit - durationLeft;
        return slackTime;
    }
}
