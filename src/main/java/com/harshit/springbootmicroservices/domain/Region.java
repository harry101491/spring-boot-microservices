package com.harshit.springbootmicroservices.domain;

public enum Region {
    CENTRAL_COAST("CENTRAL_COAST"), 
    SOUTHERN_CALIFORNIA("SOUTHERN_CALIFORNIA"),
    NORTHERN_CALIFORNIA("NORTHERN_CALIFORNIA"),
    VARIES("VARIES");

    private String label;

    private Region(String label) {
        this.label = label;
    }

    public static Region findByLabel(String label) {
        for(Region r: Region.values()) {
            if(r.label.equalsIgnoreCase(label)) {
                return r;
            }
        }
        return null;
    }
}