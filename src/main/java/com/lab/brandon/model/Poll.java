package com.lab.brandon.model;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Poll implements Comparable<Poll> {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 100
    )

    public long id;
    public String question;
    public int upvotes;
    public int downvotes;

    public Poll (){}

    public Poll (String question) {
        this.question = question;
    }

    @Override
    public int compareTo (Poll q) {
        int totalVotesThis = this.upvotes - this.downvotes;
        int totalVotesQ = q.upvotes - q.downvotes;
        return totalVotesQ - totalVotesThis;
    }
}
