package ttr.Services;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

import static ttr.Constants.ClientConstants.*;

public class SoundService {
    private static SoundService controller;
    private MediaPlayer player;


    public SoundService() {
        Media backgroundMusic = new Media(getClass().getResource("/ttr/music/europe.mp3").toString());
        player = new MediaPlayer(backgroundMusic);
        player.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void playMusic() {
        System.out.println(player.getStatus());
        if (player.getStatus() != MediaPlayer.Status.PLAYING) {
            player.setVolume(0.1);
            player.play();
        }
    }

    public void playSFX(String choice) {
        AudioClip clip;
        if (Objects.equals(choice, SFX_PULLCARD)) {
            clip = new AudioClip(getClass().getResource("/ttr/sfx/card_dealt3.mp3").toString());

        } else if (Objects.equals(choice, SFX_BUTTONCLICK)) {
            clip = new AudioClip(getClass().getResource("/ttr/sfx/ButtonClick.ogg").toString());

        } else if (Objects.equals(choice, SFX_PLACETRAIN)) {
            clip = new AudioClip(getClass().getResource("/ttr/sfx/train_horn2.mp3").toString());

        } else if (Objects.equals(choice, SFX_STARTGAME)) {
            clip = new AudioClip(getClass().getResource("/ttr/sfx/startGame.mp3").toString());
        } else {
            return;
        }
        clip.stop();
        clip.setVolume(0.1);
        clip.play();
    }

    public static SoundService getInstance() {
        if (controller == null) {
            controller = new SoundService();
        }

        return controller;
    }
}
