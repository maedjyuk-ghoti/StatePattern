package com.peanutbutter.clouds.statepattern.ThePattern;

import android.media.MediaPlayer;

import com.peanutbutter.clouds.statepattern.ThePattern.IPlayingState;

public class Player {

    private IPlayingState playingState;
    private MediaPlayer mediaPlayer;

    Player(MediaPlayer mediaPlayer, IPlayingState startingState) {
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.setOnCompletionListener(this::handleOnComplete);

        playingState = startingState;
    }

    private void handleOnComplete(@SuppressWarnings("unused") MediaPlayer mediaPlayer) {
        this.stop();
    }

    public void play() {
        playingState = playingState.handleInput(mediaPlayer, IPlayingState.Input.PLAY);
    }

    public void pause() {
        playingState = playingState.handleInput(mediaPlayer, IPlayingState.Input.PAUSE);
    }

    public void stop() {
        playingState = playingState.handleInput(mediaPlayer, IPlayingState.Input.STOP);
    }
}
