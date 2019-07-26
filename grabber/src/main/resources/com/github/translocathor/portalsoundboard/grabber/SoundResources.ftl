package ${packageName}

<#list imports as import>
import ${import}
</#list>


class ${classname} : ICategoriesLoader {
    override fun loadCategories(): List<Category> {
        val categories = ArrayList<Category>()

        <#list categories as category>
        categories.add(Category.createFrom(
            "${category.name}",
            <#list category.sounds as sound>
                Sound.createFrom(R.raw.${sound.resourceId}, ${sound.name})<#if sound?is_last><#else>,</#if>
            </#list>
        )
        )
        </#list>

        return categories
    }
}