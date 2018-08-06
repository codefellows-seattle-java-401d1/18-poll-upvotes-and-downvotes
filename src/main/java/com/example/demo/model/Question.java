package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="questionpoll")
public class Question implements Comparable<Question>{
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1001
    )
    public long id;
    public String question;
    public int votes;

    // Requires default contstructor
    public Question(){}

    public Question(String question){
        this.question = question;
    }

    @Override
    // return -1 if this is less than the other one
    // return 0 if these two things are equal
    // return 1 if this is greater than the other one
    public int compareTo(Question o) {
        System.out.println(this.question + " had " + this.votes);
        System.out.println(o.question + " had " + o.votes);
        System.out.println("result: " + (this.votes - o.votes));
        return o.votes - this.votes;
    }
}