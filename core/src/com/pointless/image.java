package com.pointless;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class image extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	public ExerciseData exerciseData;
	private int imageCounter;
	private Texture texture;
	private String[] url;


	public image(ImageLoaderCore imageLoader, UrlHandler urlHandler)
	{
		CommonObjects.imageLoader = imageLoader;
		CommonObjects.urlHandler = urlHandler;
		CommonObjects.urlHandler.callServer();
		this.url = exerciseData.getImageUrls();
	}

	@Override
	public void create () {

		//url = "https://s3.ap-south-1.amazonaws.com/blackboardradioandroidcontent/Nursery/Image+Game/Ball.png" ;
		batch = new SpriteBatch();
		//	CommonObjects.imageLoader.loadImage(url[0], (int) Gdx.graphics.getWidth(), (int) Gdx.graphics.getHeight());
		nextImage();
		texture = CommonObjects.imageLoader.getImage();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(texture, 0, 0);
		batch.end();
	}
	private void nextImage() {
		if(imageCounter<url.length){
			CommonObjects.imageLoader.loadImage(url[imageCounter]);
		}

		//	else {
//			getImageArray();
		//	}
		imageCounter++;


	}
	@Override
	public void dispose () {
		batch.dispose();
		texture.dispose();
	}
}
