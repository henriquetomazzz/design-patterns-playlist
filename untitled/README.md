# 🎵 Projeto Player de Música em Java

## 📌 Visão Geral
Este projeto implementa um **Player de Música** em Java que simula a execução de músicas no console, exibindo uma barra de progresso similar ao Spotify, tempo decorrido e tempo restante.  
Além disso, o sistema permite **play, pause, next, previous** e utiliza múltiplos **padrões de projeto** para demonstrar boas práticas de desenvolvimento orientado a objetos.

---

## 🎯 Objetivo
Trabalho desenvolvido para a disciplina de **Padrões de Projeto**, com o objetivo de aplicar **ao menos 4 padrões de projeto** de forma prática e funcional em um sistema simples.

---

## 🛠️ Padrões de Projeto Utilizados
- **Singleton** → Garante que o `MusicPlayer` tenha apenas uma instância.  
- **Strategy** → Define diferentes formas de execução das músicas (`SequentialPlayback`, `ShufflePlayback`, `RepeatPlayback`).  
- **Command** → Permite encapsular ações do usuário (`PlayCommand`, `NextCommand`, `PreviousCommand`, etc).  
- **Observer** → Permite atualizar a interface (console) sempre que o player muda de estado.  
- **MVC** (extra) → Separação em `model`, `view` e `controller`, deixando o projeto mais organizado.  

---

## 🚀 Funcionalidades
- Adicionar músicas em uma playlist.
- Tocar músicas simulando tempo real.
- Mostrar barra de progresso (`[tempo decorrido] ███████ [tempo restante]`).
- Pausar e retomar músicas.
- Pular para próxima (`next`) ou voltar (`previous`) música.
- Diferentes estratégias de execução: **sequencial, shuffle ou repeat**.

---

## 📂 Estrutura do Projeto
```
src/
 ├── model/
 │    ├── Song.java
 │    ├── Playlist.java
 │    ├── MusicPlayer.java
 │    ├── PlaybackStrategy.java
 │    ├── SequentialPlayback.java
 │    ├── ShufflePlayback.java
 │    ├── RepeatPlayback.java
 │
 ├── controller/
 │    ├── PlayerController.java
 │    ├── Command.java
 │    ├── PlayCommand.java
 │    ├── NextCommand.java
 │    ├── PreviousCommand.java
 │
 ├── view/
 │    ├── Observer.java
 │    ├── ConsoleView.java
 │
 └── Main.java
```

---

## ⚙️ Requisitos
- **Java 11** ou superior instalado.  
- Nenhuma dependência externa é necessária (não utiliza Maven).  

---

## ▶️ Como Executar
1. Clone este repositório:
   ```bash
   git clone https://github.com/seuusuario/player-java.git
   ```
2. Compile os arquivos `.java`:
   ```bash
   javac src/**/*.java
   ```
3. Execute o programa:
   ```bash
   java -cp src Main
   ```

---

## 🎹 Comandos Disponíveis
Durante a execução, você pode digitar no console:

| Comando | Ação |
|---------|------|
| `p`     | Play música atual |
| `n`     | Next (próxima música) |
| `b`     | Previous (música anterior) |
| `s`     | Pause / Resume |
| `q`     | Sair do player |

---

## 🎶 Playlist Inicial (exemplo)
- 3x4 - Engenheiros do Hawaii  
- Céu azul - Charlie Brown Jr  
- Smells Like Teen Spirit - Nirvana  
- Billie Jean - Michael Jackson  
- Wonderwall - Oasis  
- Imagine - John Lennon  
- Hotel California - Eagles  
- Sweet Child O' Mine - Guns N' Roses  
- Back In Black - AC/DC  
- Enter Sandman - Metallica  
- Lose Yourself - Eminem  
- Californication - Red Hot Chili Peppers  
- Everlong - Foo Fighters  
- Sultans of Swing - Dire Straits  
- November Rain - Guns N' Roses  

---

## 👨‍💻 Autor
Projeto desenvolvido por **Carlos Henrique Tomaz da Silva** para a disciplina de Padrões de Projeto.  
