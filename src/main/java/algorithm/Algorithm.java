package algorithm;

import entity.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Algorithm {
    protected List<Integer> schedule = new ArrayList();
    protected int timeUnit = 0;

    public abstract boolean execute(List<Task> tasks);

    public void printTasks() {
        for (int i = 0; i < schedule.size(); i++)
            System.out.println(i + " ---> " + generateSpace(schedule.get(i)) + schedule.get(i));
    }

    public void increaseTimeUnit() {
        timeUnit++;
    }

    private String generateSpace(int tabCount) {
        String tab = "";
        for (int i = 0; i < tabCount; i++) {
            tab += "\t";
        }
        return tab;
    }

    public boolean isDueDateExceeded(List<Task> tasks) {
        for (Task task : tasks) {
            if (task.getDueDate() < timeUnit && !task.isDone()) {
                return true;
            }
        }
        return false;
    }

    public int retrieveLatestDueDate(List<Task> tasks) {
        Task latestDeadlineTask = tasks
                .stream()
                .filter(p -> !p.isDone())
                .max(Comparator.comparing(Task::getDueDate))
                .get();
        return latestDeadlineTask.getDueDate();
    }

    public int retrieveSumOfDurations(List<Task> tasks) {
        int sum = tasks.stream().map(Task::getDuration).mapToInt(Integer::intValue).sum();
        return sum;
    }

    public void runTask(Task task) {
        if (task.getDuration() == 1) {
            task.setDone();
        }
        task.setDuration(task.getDuration() - 1);
    }

    public void addTasksToList(List<Task> tasks, int timeUnit) {
        List<Task> comingTasks = new ArrayList();
        for (Task t : tasks) {
            if (t.isOriginal() && timeUnit % t.getPeriod() == 0 && timeUnit != 0) {
                Task comingTask = new Task(t.getId(), timeUnit, t.getStableDuration(), timeUnit + t.getPeriod());
                comingTask.setPeriod(t.getPeriod());
                comingTasks.add(comingTask);
            }
        }
        tasks.addAll(comingTasks);
    }

    public boolean checkAnyTaskLeft(List<Task> tasks, int timeUnit) {
        boolean isAnyTaskLeft = tasks.stream().anyMatch(p -> p.getArrivalTime() < timeUnit && !p.isDone());
        return isAnyTaskLeft;
    }

    public List<Integer> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Integer> schedule) {
        this.schedule = schedule;
    }
}
