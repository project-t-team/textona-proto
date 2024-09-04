package view;
import java.util.Random;

import model.Hero;
import model.Item;
import model.Monster;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class GameView {
    private Scanner scanner = new Scanner(System.in);

    public void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void endBattleFlavourText() {
        Random rand = new Random();
        int textIndex = rand.nextInt(7);
        System.out.println("=================");
        switch (textIndex) {
            case 0: System.out.println("'Ganhar uma guerra é tão desastroso quanto perde-la...'\n- Agatha Cristie"); break;
            case 1: System.out.println("'E se não der certo hoje, não era pra ser.\nAí tu levanta a cabeça e vai pra guerra vender'\n- Chorão");break;
            case 2: System.out.println("'É melhor conquistar a si mesmo do que vender mil batalhas'\n- Buda");break;
            case 3: System.out.println("'Não há quem sustente uma luta mais árdua\ndo que aquele que tenta a vender a si próprio'\n- Thomas Kempis");break;
            case 4: System.out.println("'O campo da derrota não está povoado de fracassos\nmas de homens que tombaram antes de vender'\n- Abraham Lincoln");break;
            case 5: System.out.println("'Se utilizas o inimigo para derrotar o inimigo, \nserás poderoso em qualquer lugar onde fores'\n- Sun Tsu");break;
            case 6: System.out.println("'Vá cuidar da sua vida!'\n- Pablo Marçal");break;
        }
        System.out.println("=================");
    }

    public void gameoverFlavourText() {
        Random rand = new Random();
        int textIndex = rand.nextInt(7);

        List<String> names = Arrays.asList("Chorão", "Deus", "Xandão", "Pinho", "Pablo Marçal");
        Random random = new Random();
        String randomName = names.get(random.nextInt(names.size()));
        System.out.println("\u001B[90m\u001B[107mO>~-----");
        System.out.println("O fantasma de " + randomName + " Surgiu dos céus e cochichou no seu ouvido:");
        switch (textIndex) {
            case 0: System.out.println("'Ganhar uma guerra é tão desastroso quanto perde-la...'"); break;
            case 1: System.out.println("'E se não der certo hoje, não era pra ser.\nAí tu levanta a cabeça e vai pra guerra vender'");break;
            case 2: System.out.println("'É melhor conquistar a si mesmo do que vender mil batalhas'");break;
            case 3: System.out.println("'Não há quem sustente uma luta mais árdua\ndo que aquele que tenta a vender a si próprio'");break;
            case 4: System.out.println("'O campo da derrota não está povoado de fracassos\nmas de homens que tombaram antes de vender'");break;
            case 5: System.out.println("'Se utilizas o inimigo para derrotar o inimigo, \nserás poderoso em qualquer lugar onde fores'");break;
            case 6: System.out.println("'Vá cuidar da sua vida!'\n- Pablo Marçal");break;
        }
        System.out.println("O>~-----\u001B[0m");
    }

    public void displayMainMenu() {
        clear();
        System.out.println("          Murilo Caires | Paulo Gomez | Kauan Santiago | Vitor Pinho \n" +
                "                                                    _                          _ \n" +
                " _____ _______   _______ ___  _   _  ___      __   | |                   _____| |\n" +
                "(_   _)  ___) \\ / (_   _) _ \\| \\ | |/ _ \\    / /   | |   /\\        /\\   |  ___) |\n" +
                "  | | | |_   \\ v /  | || | | |  \\| | |_| |  / /_   | |  /  \\      /  \\  | |_  | |\n" +
                "  | | |  _)   > <   | || | | |     |  _  | | '_ \\  | | / /\\ \\    / /\\ \\ |  _) | |\n" +
                "  | | | |___ / ^ \\  | || |_| | |\\  | | | | | (_) ) | |/ /  \\ \\  / /__\\ \\| |___| |\n" +
                "  |_| |_____)_/ \\_\\ |_| \\___/|_| \\_|_| |_|  \\___/  | /_/    \\_\\/________\\_____) |\n" +
                "                                                   |_|                        |_|\n" +
                "Bem vindo ao mundo de Textona 6!");
        System.out.println("  1. Ir para a cidade");
        System.out.println("  2. Sair do jogo");
    }

    public void displayCityMenu() {
        System.out.println("             )                             (\n" +
                "            (                               )\n" +
                "    ________[]_                            []\n" +
                "   /^=^-^-^=^-^\\                 /^~^~^~^~^~^~\\\n" +
                "  /^-^-^-^-^-^-^\\               /^ ^ ^  ^ ^ ^ ^\\\n" +
                " /__^_^_^_^^_^_^_\\             /_^_^_^^_^_^_^_^_\\\n" +
                "  |  .==.       |               |        .--.  |\n" +
                "^^|  |LI|  [}{] |^^^^^     ^^^^^|  [}{]  |[]|  |^^^^^\n" +
                "&&|__|__|_______|&&           88|________|__|__|888\n" +
                "     ====                                ====\n" +
                "      ====                                ====\n" +
                "Você está na Cidade de CleitonVille!");
        System.out.println("  1. Ir para o mercado");
        System.out.println("  2. Partir em aventura");
        System.out.println("  3. Voltar");
    }

    public void displayMarketMenu() {
        System.out.println("Bem vindo ao Mercado do Jeff!");
        System.out.println("  1. Comprar Poção de Vida");
        System.out.println("  2. Vender item");
        System.out.println("  3. Voltar");
    }

    public void displayInventory(List<Item> inventory) {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i).getName() + " - \u001B[93m" + inventory.get(i).getValue() + " ouro\u001B[0m");
        }
    }

    public void displayCombatMenu(Hero hero, Monster monster) {
        String heroColor = "\u001B[32m";
        String monsterColor = "\u001B[32m";
        if ((double) hero.getHp() / 25 >= 0.75) {
            heroColor = "\u001B[32m";
        } else if ((double) hero.getHp() / 25 >= 0.25) {
            heroColor = "\u001B[93m";
        } else if (hero.getHp() / 25 >= 0){
            heroColor = "\u001B[31m";
        }

        if ((double) monster.getHp() / 15 >= 0.75) {
            monsterColor = "\u001B[32m";
        } else if ((double) monster.getHp() / 15 >= 0.40) {
            monsterColor = "\u001B[93m";
        } else if (monster.getHp() / 15 >= 0){
            monsterColor = "\u001B[31m";
        }

        System.out.println(
                "_________\n" +
                "|   O   |\n" +
                "|  /|\\  |\n" +
                "|  /˙\\  |   HP do Heroi: " + heroColor + hero.getHp() + "\u001B[0m/25");
        System.out.println(
                "_________\n" +
                "|   O   |\n" +
                "|  /|\\  |\n" +
                "|  /˙\\  |   HP do Monstro: " + monsterColor + monster.getHp() + "\u001B[0m/15");
        System.out.println("  1. Atacar");
        System.out.println("  2. Usar Poção de Vida");
        System.out.println("  3. Fugir");
    }

    public int getUserInput() {
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public void displayAttackMessage(String monsterName, int damage) {
        System.out.println("Você atacou " + monsterName + " e \u001B[36mcausou " + damage + " de dano!\u001B[0m");
    }

    public void displayMonsterAttackMessage(String monsterName, int damage) {
        System.out.println(monsterName + " atacou você e \u001B[31mcausou " + damage + " de dano...\u001B[0m");
    }

    public void displayHealMessage(int amount) {
        System.out.println("Você usou uma poção e \u001B[32m recuperou " + amount + " de HP!!\u001B[0m");
    }

    public void displayFleeMessage() {
        System.out.println("Você fugiu do combate...\n\n");
    }

    public void displayVictoryMessage(String monsterName) {
        System.out.println("Você derrotou " + monsterName + "!\n\u001B[36m");
        endBattleFlavourText();
        System.out.println("\u001B[0m");
    }

    public void displayDefeatMessage() {
        System.out.println("\n\u001B[31mVocê foi derrotado....");
    }

    public void displayInvalidOptionMessage() {
        clear();
        System.out.println("Opção inválida. Tente novamente.");
    }

    public void displayBuyMessage(String itemName, int value) {
        System.out.println("Você comprou " + itemName + " por \u001B[36m" + value + " ouro.\u001B[0m");
    }

    public void displaySellMessage(String itemName, int value) {
        System.out.println("Você vendeu " + itemName + " por \u001B[36m" + value + " ouro!\u001B[0m");
    }

    public void displayNotEnoughGoldMessage() {
        System.out.println("Você não tem ouro suficiente.");
    }

    public void display(String message) {
        System.out.println(message);
    }
}