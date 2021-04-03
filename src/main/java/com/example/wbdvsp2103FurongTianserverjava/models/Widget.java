package com.example.wbdvsp2103FurongTianserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topicId;
    // MongoDB, placeholder for storing, auto-increment key
    private String type;
    private Integer size;
    private String text;

    private String name; // Optional name of the widget
    private Long widgetOrder; // Order with respect to widgets in the same list
    private String url; // Absolute or relative URL referring to online resource
    private String href; // Absolute or relative URL referring to online resource

    private Long width; // Widget's horizontal & vertical size, e.g., Image's or YouTube's width & height
    private Long height; // Widget's horizontal & vertical size, e.g., Image's or YouTube's width & height
    private String src; // Absolute or relative URL referring to online resource

    private String cssClass; // CSS class implementing some CSS rule and transformations configured in some CSS rule
    private String style; // CSS transformations applied to the widget
    private String value; // Some arbitrary initial value interpreted by the widget

    private boolean ordered;

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

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(Long widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
