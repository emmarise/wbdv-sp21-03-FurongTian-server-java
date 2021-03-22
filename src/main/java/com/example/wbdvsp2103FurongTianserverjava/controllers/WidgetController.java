package com.example.wbdvsp2103FurongTianserverjava.controllers;

import com.example.wbdvsp2103FurongTianserverjava.models.Widget;
import com.example.wbdvsp2103FurongTianserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// make class accessible to HttpRequest
@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    // create an instance of the service, IC DI
    @Autowired
    WidgetService service;

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidgetForTopic(
            @PathVariable("tid") String topicId,
            @RequestBody Widget widget
    ) {
//        // controller dont handle data, so better place is service
//        widget.setTopicId(topicId);
//        widget.setId((new Date()).getTime());
        return service.createWidgetForTopic(topicId, widget);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") String topicId
    ) {
        return service.findWidgetsForTopic(topicId);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public Integer deleteWidget(@PathVariable("wid") Long id) {
        return service.deleteWidget(id);
    }

    @PutMapping("/api/widgets/{wid}")
    public Integer updateWidget(@PathVariable("wid") Long id,
                                @RequestBody Widget widget) {
        return service.updateWidget(id, widget);
    }
}
