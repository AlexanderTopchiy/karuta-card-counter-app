package com.example.android.karutacardcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            // Restore value of members from saved state
            g_scorePlayerA = savedInstanceState.getInt(KEY_scorePlayerA);
            g_scorePlayerB = savedInstanceState.getInt(KEY_scorePlayerB);
        } else {
            // Probably initialize members with default values for a new instance
            g_scorePlayerA = 25;
            g_scorePlayerB = 25;
        }
        setContentView(R.layout.activity_main);

        displayForPlayerA(g_scorePlayerA);
        displayForPlayerB(g_scorePlayerB);
    }


    /**
     * Set starting amount of cards for both players.
     */
    int g_scorePlayerA = 25;
    int g_scorePlayerB = 25;

    // Set key for save value then changing orientation.
    static final String KEY_scorePlayerA = "Player A score";
    static final String KEY_scorePlayerB = "Player B score";


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
        g_scorePlayerA--;
        displayForPlayerA(g_scorePlayerA);
    }

    /**
     * Foul for Player A.
     */
    public void foulForPlayerA(View view) {
        g_scorePlayerA++;
        g_scorePlayerB--;
        displayForPlayerA(g_scorePlayerA);
        displayForPlayerB(g_scorePlayerB);
    }

    /**
     * Double foul for Player A.
     */
    public void doubleFoulForPlayerA (View view) {
        g_scorePlayerA = g_scorePlayerA + 2;
        g_scorePlayerB = g_scorePlayerB - 2;
        displayForPlayerA(g_scorePlayerA);
        displayForPlayerB(g_scorePlayerB);
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
        g_scorePlayerB--;
        displayForPlayerB(g_scorePlayerB);
    }

    /**
     * Foul for Player B.
     */
    public void foulForPlayerB(View view) {
        g_scorePlayerB++;
        g_scorePlayerA--;
        displayForPlayerB(g_scorePlayerB);
        displayForPlayerA(g_scorePlayerA);
    }

    /**
     * Double foul for Player B.
     */
    public void doubleFoulForPlayerB (View view) {
        g_scorePlayerB = g_scorePlayerB + 2;
        g_scorePlayerA = g_scorePlayerA - 2;
        displayForPlayerB(g_scorePlayerB);
        displayForPlayerA(g_scorePlayerA);
    }


    /**
     * Start a new match.
     */
    public void startNewMatch(View view) {
        g_scorePlayerA = 25;
        g_scorePlayerB = 25;
        displayForPlayerA(g_scorePlayerA);
        displayForPlayerB(g_scorePlayerB);
    }


    /**
     * Save current state player's scores then changing orientation.
     * @param savedInstanceState player's scores.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save current state player's scores.
        savedInstanceState.putInt(KEY_scorePlayerA, g_scorePlayerA);
        savedInstanceState.putInt(KEY_scorePlayerB, g_scorePlayerB);

        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(savedInstanceState);
    }
}