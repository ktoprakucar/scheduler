package algorithm;

import task.Aperiodic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Algorithm {
    protected List<Integer> schedule = new ArrayList();
    protected int timeUnit = 0;

    public abstract boolean execute(List<Aperiodic> tasks);

    public void printTasks() {
        schedule.forEach(t -> System.out.println(generateSpace(t) + t));
    }

    public void increaseTimeUnit(){
        timeUnit++;
    }

    private String generateSpace(int tabCount) {
        String tab = "";
        for (int i = 0; i < tabCount; i++) {
            tab += "\t";
        }
        return tab;
    }

    public boolean isDueDateExceeded(List<Aperiodic> tasks) {
        for (Aperiodic task : tasks) {
            if (task.getDueDate() < timeUnit && !task.isDone()) {
                return true;
            }
        }
        return false;
    }

    public int retrieveLatestDueDate(List<Aperiodic> tasks){
        Aperiodic latestDeadlineTask = tasks
                .stream()
                .filter(p -> !p.isDone())
                .max(Comparator.comparing(Aperiodic::getDueDate))
                .get();
        return latestDeadlineTask.getDueDate();
    }

    public List<Integer> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Integer> schedule) {
        this.schedule = schedule;
    }
}
