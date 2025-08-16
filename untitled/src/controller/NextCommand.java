package controller;

import model.MusicPlayer;

/*
 * Comando concreto para avançar para a próxima música.
 */
public class NextCommand implements Command {
    private final MusicPlayer player;

    public NextCommand(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.next();
    }
}
