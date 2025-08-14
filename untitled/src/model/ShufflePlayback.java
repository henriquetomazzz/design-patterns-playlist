package model;

//TODO: adicionar comentários explicando melhor o código;
import java.util.List;
import java.util.Random;

public class ShufflePlayback implements PlaybackStrategy {
    private Random random = new Random();
    @Override
    public Song nextSong(List<Song> playlist, int currentIndex) {
        if (playlist.isEmpty()) return null;
        return playlist.get(random.nextInt(playlist.size()));
    }
}