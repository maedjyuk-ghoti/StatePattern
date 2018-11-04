package com.peanutbutter.clouds.statepattern.ThePattern;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;

public class Paused implements IPlayingState {

    @Override
    public IPlayingState handleInput(@NonNull MediaPlayer mediaPlayer, Input input) {
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

    private void handlePlay(@NonNull MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }

    private void handleStop(@NonNull MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
    }
}
