package com.github.translocathor.portalsoundboard;

import com.github.translocathor.portalsoundboard.model.Sound;

import java.util.ArrayList;
import java.util.List;

public class SoundProvider {
    public List<Sound> getSounds() {
        final List<Sound> sounds = new ArrayList<>();
        sounds.add(Sound.createFrom(R.raw.turret_turret_autosearch_1_de, "Hallooo"));
        sounds.add(Sound.createFrom(R.raw.turret_turret_autosearch_2_de, "Suche"));
        sounds.add(Sound.createFrom(R.raw.turret_turret_autosearch_3_de, "Sondiere"));
        sounds.add(Sound.createFrom(R.raw.turret_turret_autosearch_4_de, "Späh Modus aktiviert"));
        sounds.add(Sound.createFrom(R.raw.turret_turret_autosearch_5_de, "Ist dort jemand?"));
        sounds.add(Sound.createFrom(R.raw.turret_turret_autosearch_6_de, "Könnten sie bitte her kommen?"));

        // In die Luft geschossener Geschützturm
        sounds.add(Sound.createFrom(R.raw.turret_turretlaunched01_de, "Huiii"));
        sounds.add(Sound.createFrom(R.raw.turret_turretlaunched02_de, "Huiiiiiii"));
        sounds.add(Sound.createFrom(R.raw.turret_turretlaunched03_de, "Ich habe Höhenangst"));
        sounds.add(Sound.createFrom(R.raw.turret_turretlaunched04_de, "Neinnnn"));
        sounds.add(Sound.createFrom(R.raw.turret_turretlaunched05_de, "Bis bald"));
        sounds.add(Sound.createFrom(R.raw.turret_turretlaunched06_de, "Ich hab Angst 1/2"));
        sounds.add(Sound.createFrom(R.raw.turret_turretlaunched07_de, "Ich hab Angst 2/2"));
        sounds.add(Sound.createFrom(R.raw.turret_turretlaunched08_de, "Hura"));
        sounds.add(Sound.createFrom(R.raw.turret_turretlaunched09_de, "Süße Freiheit"));
        sounds.add(Sound.createFrom(R.raw.turret_turretlaunched11_de, "Ich fliege"));
        sounds.add(Sound.createFrom(R.raw.turret_turretlaunched11_de, "Machs gut"));
        return sounds;
    }
}
