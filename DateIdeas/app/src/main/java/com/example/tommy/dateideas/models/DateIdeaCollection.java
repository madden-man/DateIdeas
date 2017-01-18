package com.example.tommy.dateideas.models;

import java.util.ArrayList;
import java.util.Stack;

/**
 * DateIdeas: Created by Tommy Madden on 12/30/2016
 */
public class DateIdeaCollection {
    private static DateIdeaCollection ourInstance = new DateIdeaCollection();

    public static DateIdeaCollection getInstance() {
        return ourInstance;
    }

    private ArrayList<DateIdea> dateIdeas;
    private Circle[] circles;
    private ArrayList<Integer> restricted;

    private int numIdeas;

    private DateIdeaCollection() {

        dateIdeas = new ArrayList<DateIdea>();
        circles = new Circle[12];
        restricted = new ArrayList<Integer>();
        numIdeas = 0;
    }

    public DateIdea getIdea(int index) {
        for (int i = 0; i < restricted.size(); ++i) {
            if (index == restricted.get(i)) {
                return null;
            }
        }
        return dateIdeas.get(index);
    }

    public Circle getCircle(int index) { return circles[index]; }

    public Circle getCircleById(int id) {
        for (int i = 0; i < circles.length; ++i) {
            if (circles[i].getId() == id) {
                return circles[i];
            }
        }
        return null;
    }

    public void addIdea(String title, String desc, int drawable) {
        dateIdeas.add(new DateIdea(numIdeas, title, desc, drawable));
        numIdeas++;
    }

    public void removeIdea(int ideaIndex) {
        restricted.add(ideaIndex);
        for (int i = 0; i < circles.length; ++i) {
            circles[i].removeIdea(ideaIndex);
        }
    }

    public void addCircle(int circleIndex, int circleId) {
        circles[circleIndex] = new Circle(circleId);
    }

    public int getNumIdeas() {
        return numIdeas;
    }
}
