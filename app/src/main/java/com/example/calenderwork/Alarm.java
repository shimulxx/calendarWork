package com.example.calenderwork;

public class Alarm {
   private int hour;
   private int min;
   private String message;

    public Alarm(int hour, int min, String message) {
        this.hour = hour;
        this.min = min;
        this.message = message;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "hour=" + hour +
                ", min=" + min +
                ", message='" + message + '\'' +
                '}';
    }
}
