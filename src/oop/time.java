package ru.spbu.arts.java.oop.time;


public class time {
    int hours;
    int minutes;

    time(int h, int m) {
        this.hours = h;
        this.minutes = m;
    }

    public String show() {
        String h = Integer.toString(hours);
        String m = Integer.toString(minutes);
        if (h.length() == 1)
            h = "0" + h;
        if (m.length() == 1)
            m = "0" + m;
        return h + ":" + m;
    }


    public boolean isMorning() {
        return (hours > 6 && hours <= 12);
    }
    public boolean isDay() {
        return (hours > 12 && hours <= 18);
    }
    public boolean isEvening() {
        return (hours > 18 && hours <= 24);
    }
    public boolean isNight() {
        return (hours <= 6);
    }


    public String sayHello() {
        if (isMorning())
            return "Доброе утро";
        if (isDay())
            return "Добрый день";
        if (isEvening())
            return "Добрый вечер";
        else
            return "Доброй ночи";
    }


    public void add(int add_min) {
        int hours_temp = (this.minutes + add_min) / 60;
        int addHours = (this.hours + hours_temp) % 24;
        int addMinutes = (this.minutes + add_min) % 60;
        this.hours = addHours;
        this.minutes = addMinutes;
    }
}
