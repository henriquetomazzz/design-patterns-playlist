package exceptions;

/**
 * Exceção lançada quando o player tenta reproduzir
 * uma música mas a playlist está vazia.
 */
public class PlaylistEmptyException extends RuntimeException {
    public PlaylistEmptyException(String message) {
        super(message);
    }
}
