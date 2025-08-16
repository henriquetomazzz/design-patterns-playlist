package controller;

import java.util.HashMap;
import java.util.Map;

/*
 * Mapeia entradas do usuário (ex.: "p", "n", "b") para objetos Command.
 * É o "invoker" do padrão Command: recebe uma string e executa o comando associado.
 */
public class PlayerController {
    private final Map<String, Command> bindings = new HashMap<>();

    /*
     * Associa uma entrada (tecla/comando) a um Command.
     * Ex.: bind("p", new PlayCommand(player));
     */
    public void bind(String input, Command command) {
        if (input == null || command == null) return;
        bindings.put(input.toLowerCase(), command);
    }

    /*
     * Tenta resolver e executar o comando associado à entrada.
     * @return true se encontrou e executou, false caso contrário.
     */
    public boolean handle(String rawInput) {
        if (rawInput == null) return false;
        Command cmd = bindings.get(rawInput.toLowerCase());
        if (cmd == null) return false;
        cmd.execute();
        return true;
    }
}
