package com.peanutbutter.clouds.statepattern.ThePattern;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;

import com.peanutbutter.clouds.statepattern.IPlayer;

public class Player implements IPlayer {

    private IPlayingState playingState;
    private MediaPlayer mediaPlayer;

    public Player(@NonNull MediaPlayer mediaPlayer, IPlayingState startingState) {
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

    public void skipForward() {
        playingState = playingState.handleInput(mediaPlayer, IPlayingState.Input.SKIP_FORWARD);
    }
}
