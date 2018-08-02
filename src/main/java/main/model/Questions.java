package main.model;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Questions implements Comparable<Questions>{
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 50
    )
    public long id;
    public String question;
    public int upvotes;
    public int downvotes;

    // requires default constructor
    public Questions(){}

    public Questions(String question, int upvotes, int downvotes) {
        this.question = question;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    @Override
    // return -1 if this is less than the other one
    // return  0 if these two things are equal
    // return  1 if this is greater than the other one
    public int compareTo(Questions o) {
        return o.upvotes - this.upvotes;
    }
}
