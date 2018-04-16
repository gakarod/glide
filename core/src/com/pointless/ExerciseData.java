package com.pointless;


public class ExerciseData {

    private int id;
    private int ex_type,priority;
    private String grade;
    public String[] image_urls;
    private String[] words;
    private String[] sentences;
    private String object_string;
    private String name;

    public ExerciseData(ExerciseData old){

        this.image_urls =  old.getImageUrls();
        
    }

    public ExerciseData() {

    }



    public String[] getImageUrls(){
        if(image_urls[0].equals(null))
            return null ;
        else
           return  image_urls;
    }


    public String[] getWords(){ return  words;}
}
