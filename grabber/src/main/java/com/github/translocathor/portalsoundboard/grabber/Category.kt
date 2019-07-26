package com.github.translocathor.portalsoundboard.grabber

import java.util.Arrays

class Category {
    var name: String? = null
    var sounds: List<Sound>? = null

    constructor(name: String, vararg sounds: Sound) {
        this.name = name
        this.sounds = Arrays.asList(*sounds)
    }

    constructor(name: String, sounds: List<Sound>) {
        this.name = name
        this.sounds = sounds
    }

    companion object {

        fun createFrom(name: String, sounds: List<Sound>): Category {
            return Category(name, sounds)
        }

        fun createFrom(name: String, vararg sounds: Sound): Category {
            return Category(name, *sounds)
        }
    }
}
