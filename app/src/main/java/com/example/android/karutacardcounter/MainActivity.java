package com.example.android.karutacardcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.karutacardcounter.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Set starting amount of cards for both players.
     */
    int scorePlayerA = 25;
    int scorePlayerB = 25;


    /**
     * Displays the remaining cards for Player A.
     */
    public void displayForPlayerA(int score) {
        TextView scoreView = findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Knocked card for Player A.
     */
    public void knockedCardForPlayerA(View view) {
        scorePlayerA--;
        displayForPlayerA(scorePlayerA);
    }

    /**
     * Foul for Player A.
     */
    public void foulForPlayerA(View view) {
        scorePlayerA++;
        scorePlayerB--;
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
    }

    /**
     * Double foul for Player A.
     */
    public void doubleFoulForPlayerA (View view) {
        scorePlayerA = scorePlayerA + 2;
        scorePlayerB = scorePlayerB - 2;
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
    }


    /**
     * Displays the remaining cards for Player B.
     */
    public void displayForPlayerB(int score) {
        TextView scoreView = findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Knocked card for Player B.
     */
    public void knockedCardForPlayerB(View view) {
        scorePlayerB--;
        displayForPlayerB(scorePlayerB);
    }

    /**
     * Foul for Player B.
     */
    public void foulForPlayerB(View view) {
        scorePlayerB++;
        scorePlayerA--;
        displayForPlayerB(scorePlayerB);
        displayForPlayerA(scorePlayerA);
    }

    /**
     * Double foul for Player B.
     */
    public void doubleFoulForPlayerB (View view) {
        scorePlayerB = scorePlayerB + 2;
        scorePlayerA = scorePlayerA - 2;
        displayForPlayerB(scorePlayerB);
        displayForPlayerA(scorePlayerA);
    }


    /**
     * Start a new match.
     */
    public void startNewMatch(View view) {
        scorePlayerA = 25;
        scorePlayerB = 25;
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
    }
}