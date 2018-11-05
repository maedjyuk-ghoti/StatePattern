package com.peanutbutter.clouds.statepattern;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.peanutbutter.clouds.statepattern.TheAntiPattern.AntiPlayer;
import com.peanutbutter.clouds.statepattern.ThePattern.Player;
import com.peanutbutter.clouds.statepattern.ThePattern.Stopped;

public class StatePatternActivity extends AppCompatActivity {

    private IPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state_pattern_activity);

        player = createNewPlayer();
    }

    // factory method... ignore this.
    private IPlayer createNewPlayer() {
        // Start the media play in a valid state for our system.
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.hamilton_polka);
        mediaPlayer.setOnErrorListener(this::handleError);
        mediaPlayer.stop();

        return new AntiPlayer(mediaPlayer, AntiPlayer.State.STOPPED);
//        return new Player(mediaPlayer, new Stopped());
    }

    private boolean handleError(@NonNull MediaPlayer mediaPlayer,
                                @SuppressWarnings("unused") int what,
                                @SuppressWarnings("unused") int extra) {
        mediaPlayer.release();
        player = createNewPlayer();
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

    public void skipForwardClicked(View view) {
        player.skipForward();
    }
}
