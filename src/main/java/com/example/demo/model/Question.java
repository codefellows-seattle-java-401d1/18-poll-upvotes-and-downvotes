package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="untitled_table")
public class Question implements Comparable<Question>{
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 5
    )
    public long id;
    public String question;
    public int upVotes;
    public int downVotes;

    // requires default constructor
    public Question(){}

    public Question(String question) {
        this.question = question;

    }

    @Override
    // return -1 if this is less than the other one
    // return  0 if these two things are equal
    // return  1 if this is greater than the other one
    public int compareTo(Question o) {
        return o.upVotes - this.upVotes;
    }
        // trying to see if this will work for ordering downvotes in addition to upvotes. Might now need this though if it's already sorting via upvotes.
    public int compareToVote(Question o) {
        return o.downVotes - this.downVotes;
    }
}
