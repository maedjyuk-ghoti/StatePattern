package com.peanutbutter.clouds.statepattern;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.peanutbutter.clouds.statepattern.ThePattern.Player;
import com.peanutbutter.clouds.statepattern.ThePattern.Stopped;

public class StatePatternActivity extends AppCompatActivity {

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state_pattern_activity);

        // Start the media play in a valid state for our system.
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.toirneach);
        mediaPlayer.setOnErrorListener(this::handleError);
        mediaPlayer.stop();

        player = new Player(mediaPlayer, new Stopped());
    }

    private boolean handleError(@NonNull MediaPlayer mediaPlayer,
                                @SuppressWarnings("unused") int what,
                                @SuppressWarnings("unused") int extra) {
        mediaPlayer.release();
        player = new Player(mediaPlayer, new Stopped());
        return true;
    }

    public void playClicked(View view) {
        player.play();
    }

    public void pauseClicked(View view) {
        player.pause();
    }

    public void stopClicked(View view) {
        player.stop();
    }
}
