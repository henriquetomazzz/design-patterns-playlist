package controller;

//TODO: adicionar comentários explicando melhor o código;
import model.MusicPlayer;

public class PlayCommand implements Command {
    private MusicPlayer player;
    public PlayCommand(MusicPlayer player) { this.player = player; }

    @Override
    public void execute() {
        player.play();
    }
}