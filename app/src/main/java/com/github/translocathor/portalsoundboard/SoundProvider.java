package com.github.translocathor.portalsoundboard;

import com.github.translocathor.portalsoundboard.model.Sound;

import java.util.ArrayList;
import java.util.List;

public class SoundProvider {
    public List<Sound> getSounds() {
        final List<Sound> sounds = new ArrayList<>();

        sounds.add(Sound.createFrom(R.raw.turret_turret_autosearch_1_de, "Hallooo"));
//        Field[] fields = R.raw.class.getFields();
//        for (Field field : fields) {
//            sounds.add(field.getName());
//        }
        return sounds;
    }
}
