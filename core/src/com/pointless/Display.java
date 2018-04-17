package com.pointless;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by vaibh on 16-04-2018.
 */

public class Display implements Screen {

    public final image game;
    public  int imageCounter = 0;
    private String[] url;
    private Texture texture;
    private ExerciseData exercise;
    private boolean textureLoaded = false;
    int j = 0 ;

    public Display(final image game,ExerciseData exerciseData){
        this.game = game;
        this.exercise = exerciseData;
        url = exercise.getImageUrls();


        CommonObjects.imageLoader.setOnImageLoadedListener(new OnImageLoaded() {
            @Override
            public void setTexture() {
                textureLoaded = true;
            }
        });
        //nextImage();
    }

    private void nextImage() {
        if( Gdx.input.isTouched()) {
            imageCounter++;
        }

            CommonObjects.imageLoader.loadImage(url[imageCounter]);
        texture = CommonObjects.imageLoader.getImage();


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        game.batch.begin();
        nextImage();


        if (texture != null) {
            game.batch.draw(texture, 0, 0);
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
texture.dispose();
    }
}
