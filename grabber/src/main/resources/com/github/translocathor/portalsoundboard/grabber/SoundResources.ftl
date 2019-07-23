package ${packageName};

<#list imports as import>
import ${import};
</#list>


public class ${classname} implements ICategoriesLoader {
    @Override
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();

        <#list categories as category>
            categories.add(Category.createFrom("${category.name}",
                <#list category.sounds as sound>
                    Sound.createFrom(R.raw.${sound.resourceId}, ${sound.name})<#if sound?is_last><#else>,</#if>
                </#list>
            ));
        </#list>

        return categories;
    }
}