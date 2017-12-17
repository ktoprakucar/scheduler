import entity.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {

    public List<Task> read(String fileName) throws IOException {
        List<String> lines = Files.lines(Paths.get(fileName))
                .collect(Collectors.toList());
        List<Task> tasks = generateTasks(lines);
        return tasks;
    }

    private List<Task> generateTasks(List<String> lines) {
        List<Task> tasks = new ArrayList();
        int id = 1;
        int numberOfTasks = Integer.valueOf(lines.get(0));
        lines.remove(0);
        for (int i = 0; i < numberOfTasks; i++) {
            String[] values = lines.get(i).split(" ");
            Task task = new Task(id++, Integer.valueOf(values[1]), Integer.valueOf(values[2]), Integer.valueOf(values[3]));
            if ("1".equals(values[0])) {
                task.setDone();
            }
            tasks.add(task);
        }
        return tasks;
    }
}
