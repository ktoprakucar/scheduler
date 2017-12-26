package entity;

public class Task {
    private final int id;
    private int arrivalTime;
    private int duration;
    private int dueDate;
    private int period;
    private boolean isPeriodic;
    private boolean isDone;
    private final int stableDuration;
    private boolean isOriginal;

    public Task(int id, int arrivalTime, int duration, int dueDate) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.dueDate = dueDate;
        stableDuration = duration;
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

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    public boolean isPeriodic() {
        return isPeriodic;
    }

    public void setPeriodic() {
        isPeriodic = true;
        period = dueDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone() {
        isDone = true;
    }

    public int getStableDuration() {
        return stableDuration;
    }

    public boolean isOriginal() {
        return isOriginal;
    }

    public void setOriginal(boolean original) {
        isOriginal = original;
    }
}
