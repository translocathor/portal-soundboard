package com.github.translocathor.portalsoundboard.model;

public class Sound {
    private int resourceId;
    private String name;

    public Sound(int resourceId, String name) {
        this.resourceId = resourceId;
        this.name = name;
    }

    public static Sound createFrom(int resourceId, String name) {
        return new Sound(resourceId, name);
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
