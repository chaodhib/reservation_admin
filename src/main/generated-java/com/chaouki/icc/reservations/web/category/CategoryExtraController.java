package com.chaouki.icc.reservations.web.category;

import com.chaouki.icc.reservations.domain.Category;
import com.chaouki.icc.reservations.domain.Shows;
import com.chaouki.icc.reservations.domain.Shows_;
import com.chaouki.icc.reservations.repository.CategoryRepository;
import com.chaouki.icc.reservations.repository.ShowsRepository;
import com.chaouki.icc.reservations.web.faces.ViewScoped;
import com.jaxio.jpa.querybyexample.SearchParameters;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import static com.jaxio.jpa.querybyexample.PropertySelector.newPropertySelector;

@Named
@ViewScoped
public class CategoryExtraController {

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private ShowsRepository showsRepository;

    private List<CategoryBundle> categoryBundleList;

    @PostConstruct
    public void init() {
        categoryBundleList = new ArrayList<>();

        List<Category> categories = categoryRepository.find();
        for (Category category : categories) {
            CategoryBundle categoryBundle = new CategoryBundle();
            categoryBundle.setCategory(category);

            SearchParameters searchParameters = new SearchParameters();
            searchParameters.property(newPropertySelector(Shows_.category).selected(category));
            List<Shows> shows = showsRepository.find(searchParameters);
            categoryBundle.setShowsList(shows);

            categoryBundleList.add(categoryBundle);
        }
    }

    public List<CategoryBundle> getCategoryBundleList() {
        return categoryBundleList;
    }
}
