package model;

//TODO: adicionar comentários explicando melhor o código;
import java.util.List;

public interface PlaybackStrategy {
    Song nextSong(List<Song> playlist, int currentIndex);
}