package com.company;
//package ua.com.prologistic.composition;

public class Student {
    Student(String S_fio, RecordBook S_rb) {
        this.S_fio = S_fio;
        this.S_rb = S_rb;
    }
    private String S_fio;
    private RecordBook S_rb;
}
