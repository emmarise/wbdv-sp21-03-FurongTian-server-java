package com.example.wbdvsp2103FurongTianserverjava.models;

public class Widget {
    // eventually store them in DB, first array in
    private Long id;
    private String topicId;
    // MongoDB, placeholder for storing, auto-increment key
    private String type;
    private Integer size;
    private String text;

    private String name; // Optional name of the widget
    private Long widgetOrder; // Order with respect to widgets in the same list
    private String src; // Absolute or relative URL referring to online resource
    private String url; // Absolute or relative URL referring to online resource
    private String href; // Absolute or relative URL referring to online resource
    private Long width; // Widget's horizontal & vertical size, e.g., Image's or YouTube's width & height
    private Long height; // Widget's horizontal & vertical size, e.g., Image's or YouTube's width & height
    private String cssClass; // CSS class implementing some CSS rule and transformations configured in some CSS rule
    private String style; // CSS transformations applied to the widget
    private String value; // Some arbitrary initial value interpreted by the widget


    // we need default one
    public Widget() {
    }

    public Widget(Long id, String topicId, String type, Integer size, String text) {
        this.id = id;
        this.topicId = topicId;
        this.type = type;
        this.size = size;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
