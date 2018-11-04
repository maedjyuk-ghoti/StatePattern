package com.peanutbutter.clouds.statepattern.TheAntiPattern;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import com.peanutbutter.clouds.statepattern.IPlayer;

import java.io.IOException;

public class AntiPlayer implements IPlayer {

    private MediaPlayer mediaPlayer;
    private State currentState;

    public AntiPlayer(@NonNull MediaPlayer mediaPlayer, State startingState) {
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.setOnCompletionListener(this::handleOnComplete);

        currentState = startingState;
    }

    private void handleOnComplete(@SuppressWarnings("unused") MediaPlayer mediaPlayer) {
        this.stop();
    }

    @Override
    public void play() {
        switch (currentState) {
            case PLAYING:
                return;
            case PAUSED:
                mediaPlayer.start();
                break;
            case STOPPED:
                try {
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void pause() {
        switch (currentState) {
            case PLAYING:
                mediaPlayer.pause();
                break;
            case PAUSED:
                return;
            case STOPPED:
                try {
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    mediaPlayer.pause();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void stop() {
        switch (currentState) {
            case PLAYING:
                mediaPlayer.stop();
                break;
            case PAUSED:
                mediaPlayer.stop();
                break;
            case STOPPED:
                break;
        }
    }

    public enum State {
        PLAYING, PAUSED, STOPPED
    }
}
