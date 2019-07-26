package com.github.translocathor.portalsoundboard.model

class Sound(var resourceId: Int, var name: String) {
    companion object {

        fun createFrom(resourceId: Int, name: String): Sound {
            return Sound(resourceId, name)
        }
    }
}
