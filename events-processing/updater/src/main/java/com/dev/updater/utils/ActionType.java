package com.dev.updater.utils;

public enum ActionType{
    LIKE("like"),UNLIKE("unlike");

    private String type;
    private ActionType(String type){
        this.type=type;
    }

    public String getType(){
        return type;
    }
}
