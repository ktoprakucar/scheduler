package algorithm.periodic;

import algorithm.Algorithm;
import calculation.MathUtil;
import entity.Task;

import java.util.*;
import java.util.stream.Collectors;

public class RateMonotonic extends Algorithm {

    private final List<Double> utilizationValueList = Arrays.asList(1.0, 0.828, 0.780, 0.757, 0.743, 0.734, 0.728, 0.724);
    private List<Task> taskList = new ArrayList();

    @Override
    public boolean execute(List<Task> tasks) {
        if (checkUtilisationValue(tasks)) {
            return false;
        }
        int lcm = calculateLcm(tasks);
        for (int i = 0; i < lcm; i++) {
            addTasksToList(tasks, i);
            Task task = retrieveHighestPriority(tasks, i);
            schedule.add(task.getId());
            runTask(task);
            increaseTimeUnit();
        }
        return true;
    }

    private void addTasksToList(List<Task> tasks, int timeUnit) {
        List<Task> comingTasks = new ArrayList();
        for (Task t : tasks) {
            if (timeUnit % t.getPeriod() == 0) {
                comingTasks.add(new Task(t.getId(), timeUnit, t.getDuration(), timeUnit + t.getPeriod()));
            }
        }
        taskList.addAll(comingTasks);
    }

    private int calculateLcm(List<Task> tasks) {
        int[] durations = tasks.stream().mapToInt(p -> p.getDueDate()).toArray();
        int lcm = MathUtil.lcm(durations);
        return lcm;
    }

    public boolean checkUtilisationValue(List<Task> tasks) {
        double totalValue = 0.0;
        if (isGCDGreaterThanOne(tasks)) {
            return true;
        }
        for (Task t : tasks) {
            totalValue += (double) t.getDuration() / t.getDueDate();
        }
        if (totalValue > utilizationValueList.get(tasks.size() - 1)) {
            return false;
        }
        return true;
    }

    private boolean isGCDGreaterThanOne(List<Task> tasks) {
        int[] numberArray = tasks.stream().mapToInt(p -> p.getDueDate()).toArray();
        int gcd = MathUtil.gcd(numberArray);
        if (gcd > 1) {
            return true;
        }
        return false;
    }

    public Task retrieveHighestPriority(List<Task> tasks, int timeUnit) {
        Random randomGenerator = new Random();
        Task highestPriorityTask = tasks
                .stream()
                .filter(p-> p.getArrivalTime() <= timeUnit)
                .filter(p -> !p.isDone())
                .min(Comparator.comparing(Task::getPeriod))
                .get();

        int highestPriorityPeriod = highestPriorityTask.getPeriod();

        List<Task> highestPriorityTasks = tasks
                .stream()
                .filter(p -> !p.isDone())
                .filter(p-> p.getArrivalTime() <= timeUnit)
                .filter(p -> p.getPeriod() == highestPriorityPeriod)
                .collect(Collectors.toList());

        int index = randomGenerator.nextInt(highestPriorityTasks.size());
        return highestPriorityTasks.get(index);
    }
}
