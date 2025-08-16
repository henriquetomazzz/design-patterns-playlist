package controller;

import model.MusicPlayer;

/*
 * Comando concreto para iniciar a reprodução no MusicPlayer.
 */
public class PlayCommand implements Command {
    private final MusicPlayer player;

    public PlayCommand(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
}
