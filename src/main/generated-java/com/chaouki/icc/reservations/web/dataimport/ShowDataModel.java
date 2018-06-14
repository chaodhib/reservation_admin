package com.chaouki.icc.reservations.web.dataimport;

import com.chaouki.icc.reservations.domain.Shows;
import org.primefaces.model.SelectableDataModel;

import javax.faces.model.ListDataModel;
import java.util.List;

public class ShowDataModel extends ListDataModel<Shows> implements SelectableDataModel<Shows> {

    public ShowDataModel(List<Shows> list) {
        super(list);
    }

    @Override
    public Object getRowKey(Shows shows) {
        return shows.getSlug();
    }

    @Override
    public Shows getRowData(String rowKey) {
        List<Shows> shows = (List<Shows>) getWrappedData();

        for(Shows show : shows) {
            if(show.getSlug().equals(rowKey))
                return show;
        }

        return null;
    }
}
