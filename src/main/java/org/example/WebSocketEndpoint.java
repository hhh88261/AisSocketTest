package org.example;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket")
public class WebSocketEndpoint {
    private static final Set<Session> clients = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);
        System.out.println("Connection opened: " + session.getId());
        try {
            session.getBasicRemote().sendText("웹소켓 접속 성공");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Message from " + session.getId() + ": " + message);

        try {
            session.getBasicRemote().sendText(message);

            broadcast(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
        System.out.println("Connection closed: " + session.getId());
    }

    private static void broadcast(String message) {
        for (Session client : clients) {
            if (client.isOpen()) {
                try {
                    client.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    System.out.println("Error broadcasting message: " + e.getMessage());
                }
            }
        }
    }
}
