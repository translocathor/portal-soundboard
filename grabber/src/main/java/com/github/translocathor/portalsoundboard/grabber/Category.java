package com.github.translocathor.portalsoundboard.grabber;

import java.util.List;

import java.util.Arrays;

public class Category {
    private String name;
    private List<Sound> sounds;

    public Category(String name, Sound... sounds) {
        this.name = name;
        this.sounds = Arrays.asList(sounds);
    }

    public Category(String name, List<Sound> sounds) {
        this.name = name;
        this.sounds = sounds;
    }

    public static Category createFrom(String name, List<Sound> sounds) {
        return new Category(name, sounds);
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
