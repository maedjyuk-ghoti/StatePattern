package com.peanutbutter.clouds.statepattern.State.ThePattern;

import android.media.MediaPlayer;

public class Playing implements IPlayingState {

    @Override
    public IPlayingState handleInput(MediaPlayer mediaPlayer, Input input) {
        switch (input) {
            case PAUSE:
                handlePause(mediaPlayer);
                return new Paused();
            case STOP:
                handleStop(mediaPlayer);
                return new Stopped();
        }
        return this;
    }

    private void handlePause(MediaPlayer mediaPlayer) {
        mediaPlayer.pause();
    }

    private void handleStop(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
    }
}
