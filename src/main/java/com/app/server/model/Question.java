package com.app.server.model;

import javax.persistence.*;

@Entity
@Table(name="question")
public class Question implements Comparable<Question>{
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1003
    )
    public long id;
    public String title;
    public String body;
    public int votes;

    // requires default constructor
    public Question(){}

    public Question(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    // return -1 if this is less than the other one
    // return  0 if these two things are equal
    // return  1 if this is greater than the other one
    public int compareTo(Question o) {
        return o.votes - this.votes;
    }
}
