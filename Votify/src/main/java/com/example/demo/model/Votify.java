package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="votes")
public class Votify implements Comparable<Votify>{
    @Id
    @GeneratedValue(generator = "votes_generator")
    @SequenceGenerator(
            name = "votes_generator",
            sequenceName = "votes_sequence",
            initialValue = 1000
    )
    public long id;
    public int upvotes;
    public int downvotes;
    public String content;

//    public int votes;

    // requires default constructor
    public Votify(String content, int upvotes, int downvotes){}

    public Votify(int upvotes, int downvotes, String content) {
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.content = content;
    }

    @Override
    // return -1 if this is less than the other one
    // return  0 if these two things are equal
    // return  1 if this is greater than the other one
    public int compareTo(Votify o) {
        return o.upvotes - this.upvotes;
    }
}
