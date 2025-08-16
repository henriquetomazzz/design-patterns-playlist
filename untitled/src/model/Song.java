package model;

/*
 * Representa uma música com título, artista e duração (em segundos).
 * Esta é uma classe simples que serve como modelo de dados.
 */
public class Song {
    private String title;  // Nome da música
    private String artist; // Nome do artista
    private int duration;  // Duração da música em segundos

    /*
     * Construtor da classe Song
     * @param title   Nome da música
     * @param artist  Nome do artista
     * @param duration Duração da música em segundos
     */
    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public int getDuration() {
        return duration;
    }
}
