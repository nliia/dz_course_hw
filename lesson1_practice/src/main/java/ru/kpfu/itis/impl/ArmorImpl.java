package ru.kpfu.itis.impl;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.Armor;

@Component
public class ArmorImpl implements Armor{
    private static String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
