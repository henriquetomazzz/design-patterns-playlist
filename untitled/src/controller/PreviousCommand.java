package controller;

import model.MusicPlayer;

/*
 * Comando concreto para voltar para a música anterior.
 */
public class PreviousCommand implements Command {
    private final MusicPlayer player;

    public PreviousCommand(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.previous();
    }
}
