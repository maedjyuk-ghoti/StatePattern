package com.peanutbutter.clouds.statepattern.StateStuff;

import android.media.MediaPlayer;

public class Paused implements IPlayingState {

    @Override
    public IPlayingState handleInput(MediaPlayer mediaPlayer, Input input) {
        switch (input) {
            case PLAY:
                handlePlay(mediaPlayer);
                return new Playing();
            case STOP:
                handleStop(mediaPlayer);
                return new Stopped();
        }
        return this;
    }

    private void handlePlay(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }

    private void handleStop(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
    }
}
