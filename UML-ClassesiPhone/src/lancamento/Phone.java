/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lancamento;

/**
 *
 * @author murilodio
 */
// Interface para Aparelho Telefônico
public interface Phone {
    void makeCall(String phoneNumber);
    void receiveCall(String callerName);
    void endCall();
}
