package ttr.Controllers;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class SoundController {
    private static SoundController controller;
    private MediaPlayer player;


    public SoundController() {
        Media backgroundMusic = new Media(getClass().getResource("/ttr/music/europe.mp3").toString());
        player = new MediaPlayer(backgroundMusic);
        player.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void playMusic() {
        System.out.println(player.getStatus());
        if (player.getStatus() != MediaPlayer.Status.PLAYING) {
            player.setVolume(0.2);
            player.play();
            System.out.println("aaa");
        }
    }

    public void playSFX(String choice) {
        AudioClip clip;
        if (Objects.equals(choice, "pullCard")) {
            clip = new AudioClip(getClass().getResource("/ttr/sfx/card_dealt3.mp3").toString());
            clip.stop();
            clip.play();
        }
    }

    public static SoundController getInstance() {
        if (controller == null) {
            controller = new SoundController();
        }

        return controller;
    }
}
