import model.*;
import java.util.Scanner;

//TODO: adicionar comentários explicando melhor o código;
//TODO: adicionar tratamento de exceções em todo o projeto;
public class Main {
    public static void main(String[] args) {
        MusicPlayer player = MusicPlayer.getInstance();

        player.addSong(new Song("3x4", "Engenheiros do Hawai", 15));
        player.addSong(new Song("Céu azul", "Charlie Brown Jr", 15));
        player.addSong(new Song("Smells Like Teen Spirit", "Nirvana", 15));
        player.addSong(new Song("Billie Jean", "Michael Jackson", 15));
        player.addSong(new Song("Wonderwall", "Oasis", 15));
        player.addSong(new Song("Imagine", "John Lennon", 15));
        player.addSong(new Song("Hotel California", "Eagles", 15));
        player.addSong(new Song("Sweet Child O' Mine", "Guns N' Roses", 15));
        player.addSong(new Song("Back In Black", "AC/DC", 15));
        player.addSong(new Song("Enter Sandman", "Metallica", 15));
        player.addSong(new Song("Lose Yourself", "Eminem", 15));

        Scanner scanner = new Scanner(System.in);
        String comando;

        System.out.println("🎵 Player de Música - Comandos:");
        System.out.println("p → Play | n → Next | s → Stop | q → Sair");

        do {
            comando = scanner.nextLine().trim().toLowerCase();
            switch (comando) {
                case "p":
                    player.play();
                    break;
                case "n":
                    player.next();
                    break;
                case "s": // pausar ou retomar
                    if (!player.isPaused()) {
                        player.pause();
                    } else {
                        player.resume();
                    }
                    break;

                case "q":
                    player.pause();
                    System.out.println("Encerrando player...");
                    break;
                default:
                    System.out.println("Comando inválido! Use p, n, s ou q.");
                    System.out.print("\nDigite comando: ");
            }
        } while (!comando.equals("q"));


        scanner.close();
    }
}
