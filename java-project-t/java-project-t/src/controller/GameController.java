 package controller;

import model.Hero;
import model.Monster;
import view.GameView;

public class GameController {
    private Hero hero;
    private GameView view;
    private boolean isRunning = true;

    public GameController(Hero hero, GameView view) {
        this.hero = hero;
        this.view = view;
    }

    public void startGame() {
        while (isRunning) {
            view.displayMainMenu();
            int choice = view.getUserInput();
            view.clear();
            switch (choice) {
                case 1:
                    handleCityMenu();
                    break;
                case 2:
                    isRunning = false;
                    break;
                default:
                    view.displayInvalidOptionMessage();
                    break;
            }
        }
    }

    private void handleCityMenu() {
        boolean inCity = true;
        while (inCity) {
            view.displayCityMenu();
            int choice = view.getUserInput();
            view.clear();
            switch (choice) {
                case 1:
                    MarketController marketController = new MarketController(hero, view);
                    marketController.enterMarket();
                    break;
                case 2:
                    handleAdventure();
                    break;
                case 3:
                    inCity = false;
                    break;
                default:
                    view.displayInvalidOptionMessage();
                    break;
            }
        }
    }

    private void handleAdventure() {
        Monster randomMonster = new Monster("Goblin", 15); // Example monster
        CombatController combatController = new CombatController(hero, view);
        combatController.startCombat(randomMonster);
    }
}