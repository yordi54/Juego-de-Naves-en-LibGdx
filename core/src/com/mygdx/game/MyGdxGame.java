package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private Helicopter helicopter;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		helicopter = new Helicopter(120,350);
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(1,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			helicopter.position_y+=200 * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			helicopter.position_y-=200 *Gdx.graphics.getDeltaTime();
		}
		if(helicopter.position_y < 0){
			helicopter.position_y = 0;
		}
		if(helicopter.position_y > 720-30){
			helicopter.position_y = 720-30;
		}
		batch.begin();
		helicopter.render(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		helicopter.dispose();
	}
}
