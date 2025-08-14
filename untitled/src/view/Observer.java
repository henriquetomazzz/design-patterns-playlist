package view;

//TODO: adicionar comentários explicando melhor o código;
import model.Song;

public interface Observer {
    void update(Song song);
}