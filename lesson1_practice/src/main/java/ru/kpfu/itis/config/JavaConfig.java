package ru.kpfu.itis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.itis.Armor;
import ru.kpfu.itis.Warrior;
import ru.kpfu.itis.Weapon;
import ru.kpfu.itis.impl.ArmorImpl;
import ru.kpfu.itis.impl.WarriorImpl;
import ru.kpfu.itis.impl.WeaponImpl;

@Configuration
public class JavaConfig {

    @Bean
    public Armor armor() {
        Armor armor = new ArmorImpl();
        armor.setType(" ");
        return armor;
    }

    @Bean
    public Weapon weapon() {
        Weapon weapon = new WeaponImpl();
        weapon.setType("");
        return weapon;
    }

    @Bean
    public Warrior warrior() {
        Warrior warrior = new WarriorImpl(armor(), weapon());
        return warrior;
    }


}
