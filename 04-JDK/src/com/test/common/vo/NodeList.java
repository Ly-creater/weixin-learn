package com.test.common.vo;

import java.util.List;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.common.vo
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class NodeList {
    private int value;
    private NodeList parent;
    private List<NodeList> child;

    public NodeList() {
    }

    public NodeList(int value, NodeList parent) {
        this.value = value;
        this.parent = parent;
    }

    public NodeList(int value, NodeList parent,  List<NodeList> child) {
        this.value = value;
        this.parent = parent;
        this.child = child;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeList getParent() {
        return parent;
    }

    public void setParent(NodeList parent) {
        this.parent = parent;
    }

    public  List<NodeList> getChild() {
        return child;
    }

    public void setChild( List<NodeList> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "NodeList{" +
                "value=" + value +
                ", parent=" + parent +
                ", child=" + child +
                '}';
    }
}
