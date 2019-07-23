package com.github.translocathor.portalsoundboard.grabber

class Sound(var resourceId: String?, var name: String?) {
    companion object {

        fun createFrom(resourceId: String, name: String): Sound {
            return Sound(resourceId, name)
        }
    }
}
