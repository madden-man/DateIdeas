package com.example.tommy.dateideas.models;

import android.util.Log;

import java.util.ArrayList;
import java.util.Stack;

/**
 * DateIdeas: Created by Tommy Madden on 12/31/2016
 */
public class Circle {
    private int id;
    private ArrayList<Integer> ideas;

    public Circle(int id) {
        this.id = id;
        ideas = new ArrayList<Integer>();
    }

    public void addDateIdea(int ideaIndex) {
        ideas.add(ideaIndex);
    }

    public Stack<DateIdea> pushStack() {
        Stack<DateIdea> dateIdeas = new Stack<DateIdea>();
        for (int i = 0; i < ideas.size(); ++i) {
            dateIdeas.push(DateIdeaCollection.getInstance().getIdea(ideas.get(i)));
            Log.d("LOGCAT", String.valueOf(ideas.get(i)));
        }
        return dateIdeas;
    }

    public int getId() {
        return id;
    }

    public int getNumIdeas() {
        return ideas.size();
    }

    public void removeIdea(int ideaIndex) {
        for (int i = 0; i < ideas.size(); ++i) {
            if (ideas.get(i) == ideaIndex) {
                ideas.remove(i);
            }
        }
    }
}
