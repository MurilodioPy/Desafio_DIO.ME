/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lancamento;

/**
 *
 * @author murilodio
 */
// Classe que implementa as funcionalidades do iPhone
public class Iphone implements MusicPlayer, Phone, InternetBrowser {
    // Implementação das funções da interface MusicPlayer
    @Override
    public void play() {
        // Código para iniciar a reprodução de música
        System.out.println("Musica rodando.. ");
    }

    @Override
    public void pause() {
        // Código para pausar a reprodução de música
        System.out.println("Musica em pause.. ");
    }

    @Override
    public void stop() {
        // Código para parar a reprodução de música
        System.out.println("Musica parada.. ");
    }

    @Override
    public void nextTrack() {
        // Código para passar para a próxima faixa de música
        System.out.println("Proxima musica: ");
    }

    @Override
    public void previousTrack() {
        // Código para voltar para a faixa anterior
        System.out.println("Musica anterior: ");
    }

    // Implementação das funções da interface Phone
    @Override
    public void makeCall(String phoneNumber) {
        // fazer uma ligação
        System.out.println("Ligando para: " + phoneNumber);
    }

    @Override
    public void receiveCall(String callerName) {
        // receber uma chamada
        System.out.println("Recebendo ligacao de: " + callerName);
    }

    @Override
    public void endCall() {
        // Código para encerrar uma chamada
        System.out.println("Finalizando a ligacao.... ");
    }

    // Implementação das funções da interface InternetBrowser
    @Override
    public void openURL(String url) {
        // Código para abrir uma URL no navegador
        System.out.println("Entrando no site: " + url);
    }

    @Override
    public void browseHistory() {
        // Código para visualizar o histórico de navegação
    }

    @Override
    public void search(String query) {
        // Código para fazer uma pesquisa na internet
    }
}

