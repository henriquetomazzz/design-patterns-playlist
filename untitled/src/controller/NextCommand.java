package controller;

//TODO: adicionar comentários explicando melhor o código;
import model.MusicPlayer;

public class NextCommand implements Command {
    private MusicPlayer player;
    public NextCommand(MusicPlayer player) { this.player = player; }

    @Override
    public void execute() {
        player.next();
    }
}