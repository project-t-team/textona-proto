package model;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int hp;
    private int gold;
    private List<Item> inventory;

    public Hero(String name) {
        this.name = name;
        this.hp = 25;
        this.gold = 0;
        this.inventory = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItemToInventory(Item item) {
        this.inventory.add(item);
    }
}