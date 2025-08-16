package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Armazena e gerencia uma lista de músicas (Song).
 */
public class Playlist {
    // Lista de músicas
    private final List<Song> songs = new ArrayList<>();

    /*
     * Adiciona uma música na playlist.
     * Verifica se a música não é nula antes de adicionar.
     */
    public void addSong(Song song) {
        if (song != null) {
            songs.add(song);
        }
    }

    /*
     * Remove uma música da playlist.
     * Retorna true se foi removida com sucesso.
     */
    public boolean removeSong(Song song) {
        return songs.remove(song);
    }

    /*
     * Retorna uma música pelo índice informado.
     * Retorna null se o índice for inválido.
     */
    public Song get(int index) {
        if (index < 0 || index >= songs.size()) return null;
        return songs.get(index);
    }

    // Retorna a quantidade de músicas na playlist
    public int size() {
        return songs.size();
    }

    // Retorna se a playlist está vazia
    public boolean isEmpty() {
        return songs.isEmpty();
    }

    // Retorna uma lista imutável com todas as músicas
    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs);
    }

    // Remove todas as músicas da playlist
    public void clear() {
        songs.clear();
    }
}
