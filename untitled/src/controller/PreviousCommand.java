package controller;

//TODO: adicionar comentários explicando melhor o código;
import model.MusicPlayer;
import model.Song;
import java.util.List;

public class PreviousCommand implements Command {
    private MusicPlayer player;
    public PreviousCommand(MusicPlayer player) { this.player = player; }

    @Override
    public void execute() {
        List<Song> songs = player.getPlaylist().getSongs();
        if (songs.isEmpty()) return;
        int index = player.getPlaylist().getSongs().indexOf(player.getCurrentSong());
        index = (index - 1 + songs.size()) % songs.size();
        player.setCurrentIndex(index);
        player.notifyObservers();
    }
}
