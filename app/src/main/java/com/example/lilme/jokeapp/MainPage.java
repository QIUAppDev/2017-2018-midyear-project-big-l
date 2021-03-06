package com.example.lilme.jokeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


public class MainPage extends Activity {
	public static final String TAG = "JokeApp";
	public static final String DEBUG_TAG = "JokeAppDebug";

	private Button buttonJokeMe;
	private Button buttonSetCategory;
	private Button buttonAddJokes;
	private Button buttonAddCats;
	private Button buttonQuit;

	private static AsyncDBHelper asyncDBHelper;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		asyncDBHelper = new AsyncDBHelper(this);

		// Sets the buttons and adds the listeners
		buttonJokeMe = (Button) findViewById(R.id.buttonJokeMe);
		buttonJokeMe.setOnClickListener(buttonsClicked);

		buttonSetCategory = (Button) findViewById(R.id.buttonSetCategory);
		buttonSetCategory.setOnClickListener(buttonsClicked);

		buttonAddJokes = (Button) findViewById(R.id.buttonAddJokes);
		buttonAddJokes.setOnClickListener(buttonsClicked);

		buttonAddCats = (Button) findViewById(R.id.buttonAddCats);
		buttonAddCats.setOnClickListener(buttonsClicked);

		buttonQuit = (Button) findViewById(R.id.buttonQuit);
		buttonQuit.setOnClickListener(buttonsClicked);
	}

	/**
	 * Returns the Async Database Helper.
	 * 
	 * @return The AsyncDBHelper Object.
	 */
	public static AsyncDBHelper getAsyncDBHelper() {
		return asyncDBHelper;
	}

	/*
	 * Listener for the buttons. If the user clicked on a button to start a new
	 * activity, calls a utility method that changes the colour of the button
	 * before starting the new activity.
	 */
	private OnClickListener buttonsClicked = new OnClickListener() {

		public void onClick(View v) {
			if (v instanceof Button) {
				switch (v.getId()) {
				case R.id.buttonJokeMe:
					Utilities.changeButtonOnClick(MainPage.this,
							ShowJoke.class, buttonJokeMe);
					break;
				case R.id.buttonSetCategory:
					Utilities.changeButtonOnClick(MainPage.this,
							SetCategory.class, buttonSetCategory);
					break;
				case R.id.buttonAddJokes:
					Utilities.changeButtonOnClick(MainPage.this, AddJoke.class,
							buttonAddJokes);
					break;
				case R.id.buttonAddCats:
					Utilities.changeButtonOnClick(MainPage.this,
							AddCategory.class, buttonAddCats);
					break;
				case R.id.buttonQuit:
					MainPage.this.finish();
					break;
				}
			}
		}
	};
}
