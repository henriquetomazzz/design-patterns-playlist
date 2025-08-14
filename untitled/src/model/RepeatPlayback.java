package model;

//TODO: adicionar comentários explicando melhor o código;
import java.util.List;

public class RepeatPlayback implements PlaybackStrategy {
    @Override
    public Song nextSong(List<Song> playlist, int currentIndex) {
        if (playlist.isEmpty()) return null;
        return playlist.get(currentIndex);
    }
}
