package ru.kpfu.itis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.Armor;
import ru.kpfu.itis.Warrior;
import ru.kpfu.itis.Weapon;

@Component
public class WarriorImpl implements Warrior {

    private Armor armor;
    private Weapon weapon;

    @Autowired
    public WarriorImpl(Armor armor, Weapon weapon) {
        this.weapon = weapon;
        this.armor = armor;
    }

    public void fight() {
        System.out.println("I'm fighting, my armor is " + armor.getType() + ", my weapon is " + weapon.getType());
    }
}
