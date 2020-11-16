package com.epam.tasks.library.entity;

public enum Cover {
    HARD ("Hard cover"),
    SOFT ("Soft cover"),
    STAPLING ("Stapling cover"),
    FRENCH ("French cover"),
    TYPOGRAPHIC ("Typographic cover"),
    THERMAL ("Thermal cover");

    private final String title;

    Cover(String s) {
        this.title = s;
    }

    public String getTitle() {
        return title;
    }

    public static boolean check(String s) {
        for(Cover cover : values()) {
            if(s.equals(cover.getTitle())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cover{" +
                "title='" + title + '\'' +
                '}';
    }
}
