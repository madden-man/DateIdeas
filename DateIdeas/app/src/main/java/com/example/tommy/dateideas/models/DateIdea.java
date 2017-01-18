package com.example.tommy.dateideas.models;

/**
 * DateIdeas: Created by Tommy Madden on 12/26/2016
 */
public class DateIdea {
    private int index;
    private String m_title;
    private String m_description;
    private int m_drawable;

    public DateIdea(int index, String title, String description, int drawable) {
        this.index = index;
        m_title = title;
        m_description = description;
        this.m_drawable = drawable;
    }

    public String getM_title() {
        return m_title;
    }

    public String getM_description() {
        return m_description;
    }

    public int getM_drawable() {
        return m_drawable;
    }

    public int getIndex() {
        return index;
    }
}
