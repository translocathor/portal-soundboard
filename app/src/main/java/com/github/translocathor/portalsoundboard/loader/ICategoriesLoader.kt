package com.github.translocathor.portalsoundboard.loader

import com.github.translocathor.portalsoundboard.model.Category

interface ICategoriesLoader {
    fun loadCategories(): List<Category>
}
