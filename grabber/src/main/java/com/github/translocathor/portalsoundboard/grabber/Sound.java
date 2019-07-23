package com.github.translocathor.portalsoundboard.grabber;

public class Sound {
    private String resourceId;
    private String name;

    public Sound(String resourceId, String name) {
        this.resourceId = resourceId;
        this.name = name;
    }

    public static Sound createFrom(String resourceId, String name) {
        return new Sound(resourceId, name);
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
