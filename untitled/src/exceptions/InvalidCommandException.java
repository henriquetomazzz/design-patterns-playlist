package exceptions;

/**
 * Exceção lançada quando o usuário digita um comando inválido no player.
 */
public class InvalidCommandException extends Exception {
    public InvalidCommandException(String message) {
        super(message);
    }
}
