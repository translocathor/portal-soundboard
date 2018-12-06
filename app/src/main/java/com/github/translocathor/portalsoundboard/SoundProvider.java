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
        return sounds;
    }
}
