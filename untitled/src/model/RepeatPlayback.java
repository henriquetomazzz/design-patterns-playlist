package model;

import java.util.List;

/*
 * Estratégia de reprodução que repete a MESMA música.
 * Retorna sempre a música do índice atual.
 */
public class RepeatPlayback implements PlaybackStrategy {

    @Override
    public Song nextSong(List<Song> songs, int currentIndex) {
        if (songs == null || songs.isEmpty()) return null;
        // mantém o mesmo índice para repetir a música atual
        return songs.get(currentIndex);
    }
}
