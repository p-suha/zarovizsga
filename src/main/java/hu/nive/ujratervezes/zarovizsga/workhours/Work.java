package hu.nive.ujratervezes.zarovizsga.workhours;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Work {

    private String name;
    private int workHours;
    private LocalDate workDay;

    public Work(String name, int workHours, LocalDate workDay) {
        this.name = name;
        this.workHours = workHours;
        this.workDay = workDay;
    }

    public String getName() {
        return name;
    }

    public int getWorkHours() {
        return workHours;
    }

    public LocalDate getWorkDay() {
        return workDay;
    }

    @Override
    public String toString() {
        return name + ": " + workDay;
    }
}
