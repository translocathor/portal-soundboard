package com.github.translocathor.portalsoundboard.model;

import java.util.Arrays;
import java.util.List;

public class Category {
    private String name;
    private List<Sound> sounds;

    public Category(String name, Sound... sounds) {
        this.name = name;
        this.sounds = Arrays.asList(sounds);
    }

    public static Category createFrom(String name, Sound... sounds) {
        return new Category(name, sounds);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sound> getSounds() {
        return sounds;
    }

    public void setSounds(List<Sound> sounds) {
        this.sounds = sounds;
    }
}
