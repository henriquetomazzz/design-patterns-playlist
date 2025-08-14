package model;

//TODO: adicionar comentários explicando melhor o código;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private final List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        if (song != null) {
            songs.add(song);
        }
    }

    public boolean removeSong(Song song) {
        return songs.remove(song);
    }

    public Song get(int index) {
        if (index < 0 || index >= songs.size()) return null;
        return songs.get(index);
    }

    public int size() {
        return songs.size();
    }

    public boolean isEmpty() {
        return songs.isEmpty();
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs);
    }

    public void clear() {
        songs.clear();
    }
}
