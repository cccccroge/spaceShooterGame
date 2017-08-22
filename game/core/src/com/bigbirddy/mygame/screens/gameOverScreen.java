package com.bigbirddy.mygame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.bigbirddy.mygame.myGame;

public class gameOverScreen implements Screen{
	
	//to access batch
	myGame game;
	
	//data
	int scorePoints;
	int HighestScorePoints;
	Preferences dataBase = Gdx.app.getPreferences("scoreBoard");
	
	//text
	BitmapFont gameover_font;
	GlyphLayout gameover_layout;
	GlyphLayout score_layout;
	GlyphLayout highestScore_layout;
	
	//constructor
	public gameOverScreen(myGame game, int scorePoints) {
		
		//access values
		this.game = game;
		this.scorePoints = scorePoints;
		
		//compare the scores and save to database
		if(scorePoints > dataBase.getInteger("highestScorePoints")) {
			dataBase.putInteger("highestScorePoints", scorePoints);
			dataBase.flush();
		}
		
		//initialize font and layout
		gameover_font = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));
		gameover_layout = new GlyphLayout(gameover_font, "Game Over!");
		score_layout = new GlyphLayout(gameover_font, "Score:" + scorePoints);
		highestScore_layout = new GlyphLayout(gameover_font, "Highest score:" + dataBase.getInteger("highestScorePoints"));
		
	}
	
	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		
		//draw gameover
		gameover_font.draw(game.batch, gameover_layout, Gdx.graphics.getWidth() / 2 - gameover_layout.width / 2, Gdx.graphics.getHeight() - 30);
		//draw score
		gameover_font.draw(game.batch, score_layout, Gdx.graphics.getWidth() / 2 - score_layout.width / 2, Gdx.graphics.getHeight() - gameover_layout.height - 60);
		//draw highest score
		gameover_font.draw(game.batch, highestScore_layout, Gdx.graphics.getWidth() / 2 - highestScore_layout.width / 2, Gdx.graphics.getHeight() - score_layout.height - 90);
		
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
		
	}

}
