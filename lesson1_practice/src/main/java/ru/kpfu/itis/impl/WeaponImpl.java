package ru.kpfu.itis.impl;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.Weapon;

@Component
public class WeaponImpl implements Weapon{
    private static String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
