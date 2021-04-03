package com.example.wbdvsp2103FurongTianserverjava.services;

import com.example.wbdvsp2103FurongTianserverjava.models.Widget;
import com.example.wbdvsp2103FurongTianserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// service's responsibility is to maintain the data, to manipulate the data,
// to work with the data
// it's not its responsibility to let it known to the rest of the world
@Service
public class WidgetService {
    @Autowired
    WidgetRepository repository;

//    private List<Widget> widgets = new ArrayList<>();
//    {
//
//    }
    public Widget createWidgetForTopic(String topicId, Widget widget) {
        widget.setTopicId(topicId);
        return repository.save(widget);
//        widget.setId((new Date()).getTime());
//        widgets.add(widget);
//        return widget;
    }

    public List<Widget> findAllWidgets() {
        return (List<Widget>) repository.findAll();
//        return widgets;
    }

    public List<Widget> findWidgetsForTopic(String topicId) {
        return repository.findWidgetsForTopic(topicId);
//        List<Widget> ws = new ArrayList<>();
//        for (Widget w : widgets) {
//            if(w.getTopicId().equals(topicId)) ws.add(w);
//        }
//        return ws;
    }

    public Integer deleteWidget(Long id) {
        repository.deleteById(id);
//        for (int i = 0; i < widgets.size(); i++) {
//            if (widgets.get(i).getId().equals(id)) {
//                widgets.remove(i);
                return 1;
//            }
//        }
//        return -1;
    }

    public Integer updateWidget(Long id, Widget widget) {
//        Widget originalWidget = repository.findById(id).get();

        // TODO: copy all the other fields testing for null
        Widget originalWidget = repository.findById(id).get();
        widget.setId(originalWidget.getId());
        repository.save(widget);
        return 1;


//        for (int i = 0; i < widgets.size(); i++) {
//            if (widgets.get(i).getId().equals(id)) {
//                widgets.set(i, widget);
//                return 1;
//            }
//        }
//        return -1;
    }
}
