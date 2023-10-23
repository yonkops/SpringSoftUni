package com.resellerapp.model.enums;

public enum ConditionName {
    EXCELLENT( "In perfect condition"),
    GOOD("Some signs of wear and tear or minor defects"),
    ACCEPTABLE("The item is fairly worn but continues to function properly");
    private String value;
    ConditionName(String s) {
        this.value = s;

    }

    public String getValue() {
        return value;
    }
}
