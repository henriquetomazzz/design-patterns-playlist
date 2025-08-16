package model;

import java.util.List;

/*
 * Define o contrato para diferentes estratégias de reprodução,
 * como sequencial, aleatória ou repetição.
 */
public interface PlaybackStrategy {
    /*
     * Retorna a próxima música a ser tocada com base na lista e no índice atual.
     * @param songs Lista de músicas
     * @param currentIndex Índice atual
     * @return Próxima música a ser tocada
     */
    Song nextSong(List<Song> songs, int currentIndex);
}
