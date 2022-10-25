package com.company;

public class myFile {
    myFile(String name, String type, String text){
        this.F_name = name;
        this.F_type = type;
        this.F_text = text;
    }
    String getF_name(){return F_name;}
    String getF_text(){return F_text;}
    String getF_type(){return F_type;}
    private String F_name;
    private String F_type;
    private String F_text;
    @Override
    public String toString() {
        return "File{ " +
                "name = '" + F_name + '\'' +
                ", type = '" + F_type + '\'' +
                ", text = " + F_text +
                '}'+ '\'';
    }
}
