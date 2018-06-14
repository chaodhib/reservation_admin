package com.chaouki.icc.reservations.web.category;

import com.chaouki.icc.reservations.domain.Category;
import com.chaouki.icc.reservations.domain.Shows;

import java.util.List;

public class CategoryBundle {

    private Category category;
    private List<Shows> showsList;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Shows> getShowsList() {
        return showsList;
    }

    public void setShowsList(List<Shows> showsList) {
        this.showsList = showsList;
    }
}
