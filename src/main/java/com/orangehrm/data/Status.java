package com.orangehrm.data;


public enum Status {
   ENABLED("Enabled"),
    DISABLED("Disabled");

    private final String status;

    private Status(String status) {
        this.status = status;
    }

    public String value() {
        return status;
    }
}

