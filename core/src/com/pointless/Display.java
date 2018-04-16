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
    public static int imageCounter;
    private String[] url;
    private Texture texture;
    private ExerciseData exercise;
    private boolean textureLoaded = false;

    public Display(final image game,ExerciseData exerciseData){
        this.game = game;
        this.exercise = exerciseData;
        url = exercise.getImageUrls();
        imageCounter = 0;

        CommonObjects.imageLoader.setOnImageLoadedListener(new OnImageLoaded() {
            @Override
            public void setTexture() {
                textureLoaded = true;
            }
        });
        nextImage();
    }

    private void nextImage() {
        if(imageCounter<url.length) {
            CommonObjects.imageLoader.loadImage(url[imageCounter], Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            imageCounter++;
        }

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
    //    Gdx.gl.glClearColor(1, 1, 1, 1);
     //   Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        if (textureLoaded) {
            texture = CommonObjects.imageLoader.getImage();
            textureLoaded = false;
        }

        if (texture != null) {
            game.batch.draw(texture, 0, 0);
        }
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

    }
}
