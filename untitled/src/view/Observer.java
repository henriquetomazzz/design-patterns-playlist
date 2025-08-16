package view;

import model.Song;

/*
 * Parte do padrão Observer, utilizada para receber atualizações
 * sobre a música que está tocando no momento.
 */
public interface Observer {
    /*
     * Método chamado pelo MusicPlayer sempre que houver
     * uma mudança de música.
     * @param song Música que está tocando atualmente
     */
    void update(Song song);
}
