package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Helicopter {
    public float position_x;
    public float position_y;
    private Animation<TextureRegion> animation;
    private float time;
    private TextureRegion[] move_image;
    private Texture image;
    private TextureRegion frame_actual;

    public Helicopter(float x, float y){
        this.position_x = x;
        this.position_y = y;
        image =  new Texture(Gdx.files.internal("helicopter.png"));
        TextureRegion[][] tmp = TextureRegion.split(image, image.getWidth()/8, image.getHeight());
        move_image =  new TextureRegion[8];
        for (int i = 0; i < 8 ; i++){
            move_image [i] = tmp[0][i];
        }
        animation = new Animation<TextureRegion>(1f/20f, move_image);
        time = 0f;
    }

    public void render(final SpriteBatch batch){
        time+= Gdx.graphics.getDeltaTime();
        frame_actual = animation.getKeyFrame(time, true);
        batch.draw(frame_actual, position_x, position_y);
    }

    public void dispose(){
        image.dispose();
    }



}
