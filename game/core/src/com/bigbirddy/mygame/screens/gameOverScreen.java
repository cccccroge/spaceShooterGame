package com.bigbirddy.mygame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
<<<<<<< HEAD
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
=======
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
>>>>>>> 098e684e88d56348d3fefc5e0e48124a4436b928
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
<<<<<<< HEAD
	GlyphLayout playAgain_layout;
	GlyphLayout backToMenu_layout;
	
=======
>>>>>>> 098e684e88d56348d3fefc5e0e48124a4436b928
	
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
<<<<<<< HEAD
		Texture t = new Texture(Gdx.files.internal("fonts/score.png"));
		t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		gameover_font = new BitmapFont(Gdx.files.internal("fonts/score.fnt"), new TextureRegion(t));
		
		gameover_layout = new GlyphLayout(gameover_font, "Game Over!");
		score_layout = new GlyphLayout(gameover_font, "Score:\n" + scorePoints);
		highestScore_layout = new GlyphLayout(gameover_font, "Highest score:\n" + dataBase.getInteger("highestScorePoints"));
		playAgain_layout = new GlyphLayout(gameover_font, "BANG!!!");
		backToMenu_layout = new GlyphLayout(gameover_font, "Back to menu");
=======
		gameover_font = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));
		gameover_layout = new GlyphLayout(gameover_font, "Game Over!");
		score_layout = new GlyphLayout(gameover_font, "Score:" + scorePoints);
		highestScore_layout = new GlyphLayout(gameover_font, "Highest score:" + dataBase.getInteger("highestScorePoints"));
>>>>>>> 098e684e88d56348d3fefc5e0e48124a4436b928
		
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
<<<<<<< HEAD
		gameover_font.draw(game.batch, highestScore_layout, Gdx.graphics.getWidth() / 2 - highestScore_layout.width / 2, Gdx.graphics.getHeight() - gameover_layout.height - score_layout.height - 75);
		
		//draw try again
		float input_x = Gdx.input.getX();
		float input_y = Gdx.input.getY();
		float try_again_x = Gdx.graphics.getWidth() / 2 - playAgain_layout.width / 2;
		float try_again_y = Gdx.graphics.getHeight() - gameover_layout.height - score_layout.height - highestScore_layout.height - 235;
		if (input_x > try_again_x && input_x < try_again_x + playAgain_layout.width && input_y > Gdx.graphics.getHeight() - try_again_y && input_y < Gdx.graphics.getHeight() - try_again_y + backToMenu_layout.height) {
			playAgain_layout.setText(gameover_font, "BANG!!", Color.YELLOW, 200, 0, false);
			gameover_font.draw(game.batch, playAgain_layout, try_again_x, try_again_y);
			if(Gdx.input.isTouched()) {
				game.gameScreen = new GameScreen(game);
				game.setScreen(game.gameScreen);
				this.dispose();
			}
			
		} else {
			playAgain_layout.setText(gameover_font, "BANG!!", Color.WHITE, 200, 0, false);
			gameover_font.draw(game.batch, playAgain_layout, try_again_x, try_again_y);
		}
		//draw Back to menu
		float back_x = Gdx.graphics.getWidth() / 2 - backToMenu_layout.width / 2;
		float back_y = Gdx.graphics.getHeight() - gameover_layout.height - score_layout.height - highestScore_layout.height - playAgain_layout.height - 250;
		if (input_x > back_x && input_x < back_x + backToMenu_layout.width && input_y > Gdx.graphics.getHeight() - back_y && input_y < Gdx.graphics.getHeight() - back_y + backToMenu_layout.height) {
			backToMenu_layout.setText(gameover_font, "Back to menu", Color.YELLOW, 400, 0, false);
			gameover_font.draw(game.batch, backToMenu_layout, back_x, back_y);
			if(Gdx.input.isTouched()) {
				game.menuScreen = new menuScreen(game);
				game.setScreen(game.menuScreen);
				this.dispose();
			}
				
		} else {
			backToMenu_layout.setText(gameover_font, "Back to menu", Color.WHITE, 400, 0, false);
			gameover_font.draw(game.batch, backToMenu_layout, back_x, back_y);
		}
		
=======
		gameover_font.draw(game.batch, highestScore_layout, Gdx.graphics.getWidth() / 2 - highestScore_layout.width / 2, Gdx.graphics.getHeight() - score_layout.height - 90);
>>>>>>> 098e684e88d56348d3fefc5e0e48124a4436b928
		
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
