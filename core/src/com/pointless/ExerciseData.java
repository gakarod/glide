package com.pointless;


public class ExerciseData {

    private int id;
    private int ex_type,priority;
    private String grade;
    private String[] image_urls;
    private String[] words;
    private String[] sentences;
    private String object_string;
    private String name;

    public ExerciseData(ExerciseData old){

        this.image_urls = old.image_urls;

    }

    public ExerciseData() {

    }



    public String[] getImageUrls(){ return  image_urls;}


    public String[] getWords(){ return  words;}
}
