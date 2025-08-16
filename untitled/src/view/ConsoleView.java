package view;

import model.Song;

/*
 * Implementa a interface Observer e serve como interface de texto
 * para exibir informações sobre a música atual no console.
 */
public class ConsoleView implements Observer {

    /*
     * Exibe no console informações da música que está tocando.
     * @param song Música atual
     */
    @Override
    public void update(Song song) {
        if (song != null) {
            System.out.println("🎵 Tocando agora: " + song.getTitle() + " - " + song.getArtist());
        } else {
            System.out.println("Nenhuma música na playlist.");
        }
    }
}
