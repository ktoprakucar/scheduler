package task;

public class Aperiodic {
    private final int id;
    private int arrivalTime;
    private int duration;
    private int dueDate;
    private boolean isDone;

    public Aperiodic(int id, int arrivalTime, int duration, int dueDate) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.dueDate = dueDate;
    }

    public void decrease(){
        duration--;
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone() {
        isDone = true;
    }
}
