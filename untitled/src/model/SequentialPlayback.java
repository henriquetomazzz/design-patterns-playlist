package model;

import java.util.List;

/*
 * Implementa PlaybackStrategy para tocar as músicas
 * na ordem em que estão na playlist (sequencial).
 */
public class SequentialPlayback implements PlaybackStrategy {
    @Override
    public Song nextSong(List<Song> songs, int currentIndex) {
        if (songs.isEmpty()) return null;
        int nextIndex = (currentIndex + 1) % songs.size(); // Volta ao início ao chegar no fim
        return songs.get(nextIndex);
    }
}
