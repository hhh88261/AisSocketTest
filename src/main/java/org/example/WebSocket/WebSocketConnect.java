package org.example.WebSocket;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.annotations.Select;
import org.example.Model.SelectShipModel;
import org.glassfish.tyrus.server.Server;

public class WebSocketConnect {

    public static void main(String[] args) throws Exception {
        //웹소켓 접속
        Map<String, Object> serverProperties = new HashMap<>();
        Server server = new Server("localhost", 7777, "/websocket", serverProperties, WebSocketEndpoint.class);

        server.start();
        System.out.println("웹소켓 열림");
        new Scanner(System.in).nextLine();
    }
}