package com.amycohen.day18_poll.model;

import javax.persistence.*;

@Entity
@Table(name="poll")
public class Poll implements Comparable<Poll>{
    @Id
    @GeneratedValue(generator = "poll_generator")
    @SequenceGenerator(
            name = "poll_generator",
            sequenceName = "poll_sequence",
            initialValue = 1000
    )
    public long id;
    public String question;
    public int upvotes;
    public int downvotes;

    // requires default constructor
    public Poll(){}

    public Poll(String question, int upvotes, int downvotes) {
        this.question = question;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    //this will sort the table based on how many upvotes they have after downvotes are subtracted
    @Override
    // return -1 if this is less than the other one
    // return  0 if these two things are equal
    // return  1 if this is greater than the other one
    public int compareTo(Poll o) {
        return o.downvotes - this.upvotes;
    }
}
