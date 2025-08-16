import controller.*;
import controller.PlayerController;
import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicPlayer player = MusicPlayer.getInstance();

        // ... adicionar suas músicas aqui ...

        // Invoker do padrão Command
        PlayerController controller = new PlayerController();
        controller.bind("p", new PlayCommand(player));
        controller.bind("n", new NextCommand(player));
        controller.bind("b", new PreviousCommand(player)); // b = back (anterior)

        System.out.println("Comandos: p=play | n=next | b=previous | s=pause/resume | q=quit");

        player.addSong(new Song("3x4", "Engenheiros do Hawaii", 15));
        player.addSong(new Song("Céu azul", "Charlie Brown Jr", 15));
        player.addSong(new Song("Smells Like Teen Spirit", "Nirvana", 12));
        player.addSong(new Song("Billie Jean", "Michael Jackson", 10));
        player.addSong(new Song("Wonderwall", "Oasis", 14));
        player.addSong(new Song("Imagine", "John Lennon", 11));
        player.addSong(new Song("Hotel California", "Eagles", 13));
        player.addSong(new Song("Sweet Child O' Mine", "Guns N' Roses", 15));
        player.addSong(new Song("Back In Black", "AC/DC", 12));
        player.addSong(new Song("Enter Sandman", "Metallica", 14));
        player.addSong(new Song("Lose Yourself", "Eminem", 13));
        player.addSong(new Song("Californication", "Red Hot Chili Peppers", 12));
        player.addSong(new Song("Everlong", "Foo Fighters", 15));
        player.addSong(new Song("Sultans of Swing", "Dire Straits", 14));
        player.addSong(new Song("November Rain", "Guns N' Roses", 15));

        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("q")) break;

            // usa Command quando existir binding; senão trata pause/resume
            boolean handled = controller.handle(input);
            if (!handled) {
                switch (input) {
                    case "s":
                        if (!player.isPaused()) player.pause(); else player.resume();
                        break;
                    default:
                        System.out.println("Comando inválido.");
                }
            }
        }
        sc.close();
    }
}
