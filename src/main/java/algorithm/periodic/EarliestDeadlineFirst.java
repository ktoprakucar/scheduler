package algorithm.periodic;

import algorithm.Algorithm;
import calculation.MathUtil;
import entity.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EarliestDeadlineFirst extends Algorithm {

    private List<Task> taskList = new ArrayList();

    @Override
    public boolean execute(List<Task> tasks) {
        if (checkUtilisationValue(tasks)) {
            return false;
        }
        int lcm = calculateLcm(tasks);
        for (int i = 0; i < lcm; i++) {
            addTasksToList(tasks, i);
            boolean isAnyTaskNotDone = tasks.stream().anyMatch(p -> !p.isDone());
            if (isAnyTaskNotDone) {
                Task task = retrieveEarliestDueDate(tasks, i);
                schedule.add(task.getId());
                runTask(task);
            } else {
                schedule.add(0);
            }
            increaseTimeUnit();
        }
        return true;
    }

    public boolean checkUtilisationValue(List<Task> tasks) {
        double totalValue = 0.0;
        for (Task t : tasks) {
            totalValue += (double) t.getDuration() / t.getDueDate();
        }
        if (totalValue > 1) {
            return true;
        }
        return false;
    }

    private int calculateLcm(List<Task> tasks) {
        int[] durations = tasks.stream().mapToInt(p -> p.getDueDate()).toArray();
        int lcm = MathUtil.lcm(durations);
        return lcm;
    }


    public Task retrieveEarliestDueDate(List<Task> tasks, int timeUnit) {
        Random randomGenerator = new Random();
        Task earliestDueDateTask = tasks
                .stream()
                .filter(p -> !p.isDone())
                .filter(p -> p.getArrivalTime() <= timeUnit)
                .min(Comparator.comparing(Task::getDueDate))
                .get();

        int earliestDueDate = earliestDueDateTask.getDueDate();

        List<Task> earliestDueDateTasks = tasks
                .stream()
                .filter(p -> !p.isDone())
                .filter(p -> p.getArrivalTime() <= timeUnit)
                .filter(p -> p.getDueDate() == earliestDueDate)
                .collect(Collectors.toList());

        int index = randomGenerator.nextInt(earliestDueDateTasks.size());
        return earliestDueDateTasks.get(index);
    }
}
