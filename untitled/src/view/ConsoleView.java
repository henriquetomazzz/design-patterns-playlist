package view;

//TODO: adicionar comentários explicando melhor o código;
import model.Song;

public class ConsoleView implements Observer {
    @Override
    public void update(Song song) {
        if (song == null) {
            System.out.println("Nenhuma música na playlist.");
        } else {
            System.out.println("Tocando agora: " + song.getTitle() + " - " + song.getArtist());
        }
    }
}