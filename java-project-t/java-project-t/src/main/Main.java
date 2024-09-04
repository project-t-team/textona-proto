package main;

import controller.GameController;
import model.Hero;
import view.GameView;

public class Main {
    public static void main(String[] args) {
        GameView view = new GameView();
        Hero hero = new Hero("Cleber");

        GameController gameController = new GameController(hero, view);
        gameController.startGame();
    }
}