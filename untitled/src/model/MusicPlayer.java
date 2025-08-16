package model;

import view.Observer;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * Implementa um player de música básico com suporte para:
 * - Adicionar músicas
 * - Reproduzir com barra de progresso
 * - Pausar, retomar e trocar de música
 * - Padrão Singleton para garantir uma única instância
 */
public class MusicPlayer {
    private static MusicPlayer instance; // Instância única (Singleton)

    private final List<Observer> observers = new ArrayList<>(); // Observadores para atualização da UI
    private final Playlist playlist = new Playlist();           // Lista de músicas

    private int currentIndex = 0;             // Índice da música atual
    private PlaybackStrategy strategy = new SequentialPlayback(); // Estratégia de reprodução
    private Thread playThread;                // Thread responsável por simular a execução
    private boolean isPlaying = false;        // Indica se está tocando
    private boolean stopRequested = false;    // Indica se foi solicitado parar

    // Códigos ANSI para cores no console
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";

    private boolean isPaused = false;         // Indica se está pausado

    // Construtor privado (Singleton)
    private MusicPlayer() {}

    // Retorna a instância única do player
    public static MusicPlayer getInstance() {
        if (instance == null) {
            instance = new MusicPlayer();
        }
        return instance;
    }

    // Define a estratégia de reprodução
    public void setStrategy(PlaybackStrategy strategy) {
        if (strategy != null) {
            this.strategy = strategy;
        }
    }

    // Inicia a reprodução da música atual
    public void play() {
        if (playlist.isEmpty()) {
            notifyObservers();
            return;
        }

        if (isPlaying) return; // Evita iniciar se já está tocando

        isPlaying = true;
        stopRequested = false;

        // Criando uma thread para simular execução da música
        playThread = new Thread(() -> {
            Song song = getCurrentSong();
            notifyObservers();

            // Limpa a tela do console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("🎵 Tocando agora: " + song.getTitle() + " - " + song.getArtist());

            int total = song.getDuration(); // Duração da música
            int barLength = 30; // Tamanho da barra de progresso

            for (int elapsed = 0; elapsed <= total; elapsed++) {
                if (stopRequested) break;

                // Pausa controlada
                synchronized (this) {
                    while (isPaused) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                    }
                }

                // Calcula tempo restante e barra de progresso
                int remaining = total - elapsed;
                String elapsedTime = BLUE + String.format("%02d:%02d", elapsed / 60, elapsed % 60) + RESET;
                String remainingTime = RED + String.format("%02d:%02d", remaining / 60, remaining % 60) + RESET;

                int filled = (int) ((elapsed / (double) total) * barLength);
                String bar = GREEN + "█".repeat(filled) + RESET + "-".repeat(barLength - filled);

                // Atualiza a linha no console
                System.out.print("\r[" + elapsedTime + "] " + bar + " [" + remainingTime + "]");
                System.out.flush();

                try {
                    Thread.sleep(1000); // Espera 1 segundo para simular o tempo real
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            isPlaying = false;

            if (!stopRequested) {
                System.out.println("\nMúsica finalizada!");
            }
            System.out.print("\nDigite comando: ");
            System.out.flush();
        });

        playThread.start();
    }

    // Pausa a reprodução
    public void pause() {
        if (isPlaying) {
            isPaused = true;
            System.out.println("\n⏸ Música pausada.");
        }
    }

    // Retorna se está pausado
    public boolean isPaused() {
        return isPaused;
    }

    // Retoma a reprodução
    public void resume() {
        if (isPaused) {
            isPaused = false;
            synchronized (this) {
                notify();
            }
            System.out.println("\n▶ Retomando música...");
        }
    }

    // Passa para a próxima música
    public void next() {
        stopRequested = true;
        isPlaying = false;
        if (playlist.isEmpty()) return;

        Song next = strategy.nextSong(playlist.getSongs(), currentIndex);
        if (next != null) {
            int idx = playlist.getSongs().indexOf(next);
            if (idx >= 0) currentIndex = idx;
        }
        play();
    }

    // Volta para a música anterior
    public void previous() {
        stopRequested = true;
        isPlaying = false;
        if (playlist.isEmpty()) return;

        currentIndex = (currentIndex - 1 + playlist.size()) % playlist.size();
        play();
    }

    // Retorna a música atual
    public Song getCurrentSong() {
        if (playlist.isEmpty()) return null;
        return playlist.get(currentIndex);
    }

    // Adiciona uma música na playlist
    public void addSong(Song song) {
        playlist.addSong(song);
        if (playlist.size() == 1) currentIndex = 0;
    }

    // Retorna a playlist
    public Playlist getPlaylist() {
        return playlist;
    }

    // Define o índice da música atual
    public void setCurrentIndex(int index) {
        if (playlist.isEmpty()) {
            currentIndex = 0;
            return;
        }
        int size = playlist.size();
        currentIndex = ((index % size) + size) % size;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    // Registra um observador
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }

    // Notifica todos os observadores
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(getCurrentSong());
        }
    }
}
