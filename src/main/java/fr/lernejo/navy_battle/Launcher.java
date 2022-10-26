package fr.lernejo.navy_battle;

import fr.lernejo.server.ServerHttp;

import java.io.IOException;

public class Launcher {

    public static void main(String args[]){
        try {
            ServerHttp serverHttp = new ServerHttp(Integer.parseInt(args[0]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
