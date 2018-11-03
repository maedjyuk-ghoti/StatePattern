package com.peanutbutter.clouds.statepattern.StateStuff;

import android.media.MediaPlayer;

import java.io.IOException;

public class Stopped implements IPlayingState {

    @Override
    public IPlayingState handleInput(MediaPlayer mediaPlayer, Input input) {
        switch (input) {
            case PAUSE:
                handlePause(mediaPlayer);
                return new Paused();
            case PLAY:
                handlePlay(mediaPlayer);
                return new Playing();
        }
        return this;
    }

    private void handlePause(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.pause();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handlePlay(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
