package com.peanutbutter.clouds.statepattern.ThePattern;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;

public class Playing implements IPlayingState {

    @Override
    public IPlayingState handleInput(@NonNull MediaPlayer mediaPlayer, Input input) {
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

    private void handlePause(@NonNull MediaPlayer mediaPlayer) {
        mediaPlayer.pause();
    }

    private void handleStop(@NonNull MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
    }
}
