package com.company;

import java.io.Serializable;

public class Ekzamen implements Serializable {
        public String subject;
        public String teacher_name;
        public int hours;
        private String date;
        private int mark;



        public Ekzamen(String subject,String teacher_name,int hours,int mark,String date){
            this.subject=subject;
            this.teacher_name=teacher_name;
            this.hours=hours;
            this.mark=mark;
            this.date=date;

        }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public String getSubject() {
        return subject;
    }

    public int getHours() {
        return hours;
    }

    public int getMark() {
        return mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    @Override
    public String toString() {
        return "Ekzamen{" +
                "subject='" + subject + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", hours=" + hours +
                ", mark=" + mark +
                '}'+ '\'';
    }
}
