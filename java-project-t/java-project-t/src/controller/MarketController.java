package controller;

import model.Hero;
import model.Item;
import view.GameView;

public class MarketController {
    private Hero hero;
    private GameView view;

    public MarketController(Hero hero, GameView view) {
        this.hero = hero;
        this.view = view;
    }

    public void enterMarket() {
        view.displayMarketMenu();
        int choice = view.getUserInput();
        view.clear();
        switch (choice) {
            case 1:
                buyPotion();
                break;
            case 2:
                sellItem();
                break;
            case 3:
                // Return
                break;
            default:
                view.displayInvalidOptionMessage();
                break;
        }
    }

    private void buyPotion() {
        if (hero.getGold() >= 10) {
            hero.setGold(hero.getGold() - 10);
            hero.addItemToInventory(new Item("Poção de Vida", 10));
            view.displayBuyMessage("Poção de Vida", 10);
        } else {
            view.displayNotEnoughGoldMessage();
        }
    }

    private void sellItem() {
        view.clear();
        if (!hero.getInventory().isEmpty()) {
            view.displayInventory(hero.getInventory());
        } else {
            System.out.println("[Não há itens no seu inventário]");
        }

        int itemIndex = view.getUserInput() - 1;
        if (itemIndex >= 0 && itemIndex < hero.getInventory().size()) {
            Item item = hero.getInventory().get(itemIndex);
            hero.setGold(hero.getGold() + item.getValue());
            hero.getInventory().remove(itemIndex);
            sellItem();
            view.displaySellMessage(item.getName(), item.getValue());
        }
    }
}