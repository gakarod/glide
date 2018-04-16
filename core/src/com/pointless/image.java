package com.pointless;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pointless.CommonObjects;
import com.pointless.ExerciseData;

public class image extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	public ExerciseData exerciseData;


	public image(ImageLoaderCore imageLoader, UrlHandler urlHandler )
	{
		CommonObjects.urlHandler = urlHandler;
		//this.exerciseData = exerciseD;
		CommonObjects.imageLoader = imageLoader;
	}

	@Override
	public void create () {

		//url = "https://s3.ap-south-1.amazonaws.com/blackboardradioandroidcontent/Nursery/Image+Game/Ball.png" ;
		batch = new SpriteBatch();
		//	CommonObjects.imageLoader.loadImage(url[0], (int) Gdx.graphics.getWidth(), (int) Gdx.graphics.getHeight());
		CommonObjects.urlHandler.callServer();

	}

	@Override
	public void render () {
		super.render();
		if (CommonObjects.urlHandler.getExercise() != null) {
			exerciseData = CommonObjects.urlHandler.getExercise();
		this.setScreen(new Display(this , exerciseData));
		}
			batch.begin();
//			batch.draw(texture, 0, 0);
			batch.end();
		}


	@Override
	public void dispose () {
		batch.dispose();
	}
}
