package controller;

//TODO: adicionar comentários explicando melhor o código;
import model.MusicPlayer;

public class PlayerController {
    private Command playCommand;
    private Command nextCommand;
    private Command prevCommand;

    public PlayerController(MusicPlayer player) {
        this.playCommand = new PlayCommand(player);
        this.nextCommand = new NextCommand(player);
        this.prevCommand = new PreviousCommand(player);
    }

    public void play() { playCommand.execute(); }
    public void next() { nextCommand.execute(); }
    public void previous() { prevCommand.execute(); }
}
