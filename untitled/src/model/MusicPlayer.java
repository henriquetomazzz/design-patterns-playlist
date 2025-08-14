package model;

//TODO: adicionar comentários explicando melhor o código;
import view.Observer;
import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private static MusicPlayer instance;

    private final List<Observer> observers = new ArrayList<>();
    private final Playlist playlist = new Playlist();

    private int currentIndex = 0;
    private PlaybackStrategy strategy = new SequentialPlayback();
    private Thread playThread;
    private boolean isPlaying = false;
    private boolean stopRequested = false;

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";

    private MusicPlayer() {}

    public static MusicPlayer getInstance() {
        if (instance == null) {
            instance = new MusicPlayer();
        }
        return instance;
    }

    public void setStrategy(PlaybackStrategy strategy) {
        if (strategy != null) {
            this.strategy = strategy;
        }
    }

    public void play() {
        if (playlist.isEmpty()) {
            notifyObservers();
            return;
        }

        if (isPlaying) return;

        isPlaying = true;
        stopRequested = false;

        playThread = new Thread(() -> {
            Song song = getCurrentSong();
            notifyObservers();

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("🎵 Tocando agora: " + song.getTitle() + " - " + song.getArtist());

            int total = song.getDuration();
            int barLength = 30;

            for (int elapsed = 0; elapsed <= total; elapsed++) {
                if (stopRequested) break;

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

                int remaining = total - elapsed;
                String elapsedTime = BLUE + String.format("%02d:%02d", elapsed / 60, elapsed % 60) + RESET;
                String remainingTime = RED + String.format("%02d:%02d", remaining / 60, remaining % 60) + RESET;

                int filled = (int) ((elapsed / (double) total) * barLength);
                String bar = GREEN + "█".repeat(filled) + RESET + "-".repeat(barLength - filled);

                System.out.print("\r[" + elapsedTime + "] " + bar + " [" + remainingTime + "]");
                System.out.flush();

                try {
                    Thread.sleep(1000);
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

    private boolean isPaused = false;

    public void pause() {
        if (isPlaying) {
            isPaused = true;
            System.out.println("\n⏸ Música pausada.");
        }
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void resume() {
        if (isPaused) {
            isPaused = false;
            synchronized (this) {
                notify();
            }
            System.out.println("\n▶ Retomando música...");
        }
    }

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

    public void previous() {
        stopRequested = true;
        isPlaying = false;
        if (playlist.isEmpty()) return;

        currentIndex = (currentIndex - 1 + playlist.size()) % playlist.size();
        play();
    }

    public Song getCurrentSong() {
        if (playlist.isEmpty()) return null;
        return playlist.get(currentIndex);
    }

    public void addSong(Song song) {
        playlist.addSong(song);
        if (playlist.size() == 1) currentIndex = 0;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

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

    public void registerObserver(Observer obs) {
        observers.add(obs);
    }

    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(getCurrentSong());
        }
    }
}
