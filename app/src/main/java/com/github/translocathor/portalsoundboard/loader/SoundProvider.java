package com.github.translocathor.portalsoundboard.loader;

import com.github.translocathor.portalsoundboard.R;
import com.github.translocathor.portalsoundboard.model.Category;
import com.github.translocathor.portalsoundboard.model.Sound;

import java.util.ArrayList;
import java.util.List;

public class SoundProvider implements ICategoriesLoader {
    public List<Sound> getSounds() {
        SoundProviderTest soundProviderTest = new SoundProviderTest();
        List<Sound> sounds = new ArrayList<>();
        for (Category c : soundProviderTest.getCategories()) {
            sounds.addAll(c.getSounds());
        }
        return sounds;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(Category.createFrom("Name",
                Sound.createFrom(R.raw.turret_turretlaunched01_de, "Huiii"),
                Sound.createFrom(R.raw.turret_turretlaunched02_de, "Huiiiiiii"),
                Sound.createFrom(R.raw.turret_turretlaunched03_de, "Ich habe Höhenangst"),
                Sound.createFrom(R.raw.turret_turretlaunched04_de, "Neinnnn"),
                Sound.createFrom(R.raw.turret_turretlaunched05_de, "Bis bald"),
                Sound.createFrom(R.raw.turret_turretlaunched06_de, "Ich hab Angst 1/2"),
                Sound.createFrom(R.raw.turret_turretlaunched07_de, "Ich hab Angst 2/2"),
                Sound.createFrom(R.raw.turret_turretlaunched08_de, "Hura"),
                Sound.createFrom(R.raw.turret_turretlaunched09_de, "Süße Freiheit"),
                Sound.createFrom(R.raw.turret_turretlaunched11_de, "Ich fliege"),
                Sound.createFrom(R.raw.turret_turretlaunched11_de, "Machs gut")
        ));
        return categories;
    }
}
