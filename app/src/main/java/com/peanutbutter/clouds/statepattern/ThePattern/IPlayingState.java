package com.peanutbutter.clouds.statepattern.ThePattern;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;

public interface IPlayingState {

    IPlayingState handleInput(@NonNull MediaPlayer mediaPlayer, Input input);

    enum Input {
        PAUSE, PLAY, STOP
    }
}
