package com.peanutbutter.clouds.statepattern.State.ThePattern;

import android.media.MediaPlayer;

public interface IPlayingState {

    IPlayingState handleInput(MediaPlayer mediaPlayer, Input input);

    enum Input {
        PAUSE, PLAY, STOP
    }
}
