package org.example;

interface MediaPlayer {
    void play(String filename);
}

class AdvancedAudioPlayer {
    void playVlc(String filename) {
        System.out.println("Проигрывание VLC: " + filename);
    }
    void playMp4(String filename) {
        System.out.println("Проигрывание MP4: " + filename);
    }
}

class MediaAdapter implements MediaPlayer {
    private AdvancedAudioPlayer advancedPlayer = new AdvancedAudioPlayer();

    public void play(String filename) {
        if (filename.endsWith(".vlc")) {
            advancedPlayer.playVlc(filename);
        } else if (filename.endsWith(".mp4")) {
            advancedPlayer.playMp4(filename);
        }
    }
}

public class AdapterPT {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter();
        player.play("movie.mp4");
        player.play("song.vlc");
    }
}
