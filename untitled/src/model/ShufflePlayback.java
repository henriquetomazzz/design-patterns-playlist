package model;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Estratégia de reprodução aleatória (embaralhada).
 * Escolhe uma próxima música diferente da atual, quando possível.
 */
public class ShufflePlayback implements PlaybackStrategy {

    @Override
    public Song nextSong(List<Song> songs, int currentIndex) {
        if (songs == null || songs.isEmpty()) return null;
        if (songs.size() == 1) return songs.get(0);

        int nextIndex;
        // sorteia até ser diferente do índice atual
        do {
            nextIndex = ThreadLocalRandom.current().nextInt(songs.size());
        } while (nextIndex == currentIndex);

        return songs.get(nextIndex);
    }
}
