package com.github.translocathor.portalsoundboard.model

import java.util.Arrays

class Category(var name: String?, vararg sounds: Sound) {
    var sounds: List<Sound>

    init {
        this.sounds = Arrays.asList(*sounds)
    }

    companion object {

        fun createFrom(name: String, vararg sounds: Sound): Category {
            return Category(name, *sounds)
        }
    }
}
