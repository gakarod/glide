package com.pointless;


public class ExerciseData {


    public String[] image_urls;


    public ExerciseData(ExerciseData old){

        this.image_urls =  old.getImageUrls();

    }

    public ExerciseData() {

    }



    public String[] getImageUrls(){

           return  image_urls;
    }
}
