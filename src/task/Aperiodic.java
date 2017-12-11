package task;

public class Aperiodic {
    private final Long id;
    private Long arrivalTime;
    private Long duration;
    private Long dueDate;

    public Aperiodic(Long id, Long arrivalTime, Long duration, Long dueDate) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.dueDate = dueDate;
    }

    public Long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getDueDate() {
        return dueDate;
    }

    public void setDueDate(Long dueDate) {
        this.dueDate = dueDate;
    }
}
