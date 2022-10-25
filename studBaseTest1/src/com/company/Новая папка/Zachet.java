package com.company;

public class Zachet {
    public String subject;
    public String teacher_name;
    public int hours;
    private boolean mark;
    public String data;

    public Zachet(String subject, String teacher_name, int hours, boolean mark, String data) {
        this.subject = subject;
        this.teacher_name = teacher_name;
        this.hours = hours;
        this.mark=mark;
        this.data = data;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getHours() {
        return hours;
    }

    public String getData() {
        return data;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public boolean getMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Zachet{" +
                "subject='" + subject + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", hours=" + hours +
                ", zachteno=" + mark +
                ", data=" + data +
                '}'+ '\'';
    }
}
