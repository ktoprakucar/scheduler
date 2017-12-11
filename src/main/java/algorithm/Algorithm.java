package algorithm;

import task.Aperiodic;

import java.util.List;

public abstract class Algorithm {
    List<Long> schedule;

    public abstract void execute(List<Aperiodic> tasks);

    public void printTasks() {
        schedule.forEach(t -> System.out.println(generateSpace(t) + t));
    }

    private String generateSpace(Long tabCount) {
        String tab = "";
        for (int i = 0; i < tabCount; i++) {
            tab += "\t";
        }
        return tab;
    }
}
