package controller;

import model.Hero;
import model.Monster;
import view.GameView;
import model.Item;

public class CombatController {
    private Hero hero;
    private GameView view;

    public CombatController(Hero hero, GameView view) {
        this.hero = hero;
        this.view = view;
    }

    public void startCombat(Monster monster) {
        while (hero.getHp() > 0 && monster.getHp() > 0) {
            view.displayCombatMenu(hero, monster);
            int choice = view.getUserInput();
            view.clear();
            switch (choice) {
                case 1:
                    attackMonster(monster);
                    break;
                case 2:
                    usePotion();
                    break;
                case 3:
                    view.displayFleeMessage();
                    return;
                default:
                    view.displayInvalidOptionMessage();
                    break;
            }
            if (monster.getHp() > 0) {
                monsterAttack(monster);
            }
        }
        if (hero.getHp() > 0) {
            view.displayVictoryMessage(monster.getName());
            hero.addItemToInventory(new Item("Carne de " + monster.getName(), 5)); // Adiciona carne do monstro ao inventário
        } else {
            view.gameoverFlavourText();
            view.displayDefeatMessage();

            System.exit(1);
        }
    }

    private void attackMonster(Monster monster) {
        int damage = 5; // Dano fixo do herói
        monster.takeDamage(damage);
        view.displayAttackMessage(monster.getName(), damage);
    }

    private void usePotion() {
        for (Item item : hero.getInventory()) {
            if (item.getName().equals("Poção de Vida")) {
                hero.setHp(hero.getHp() + 10);
                view.displayHealMessage(10);
                hero.getInventory().remove(item);
                return;
            }
        }
        view.displayInvalidOptionMessage();

    }

    private void monsterAttack(Monster monster) {
        int damage = 3; // Dano fixo do monstro
        hero.setHp(hero.getHp() - damage);
        view.displayMonsterAttackMessage(monster.getName(), damage);
    }
}