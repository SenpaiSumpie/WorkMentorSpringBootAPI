package com.workmentor.api.models;

import javax.persistence.*;

@Entity
@Table(name = "connection_table")
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String mentor;
    private String mentee;
    private boolean accepted;
    private boolean archived;

    public Connection() {}

    public Connection(Integer id, String mentor, String mentee, boolean accepted, boolean archived) {
        this.id = id;
        this.mentor = mentor;
        this.mentee = mentee;
        this.accepted = accepted;
        this.archived = archived;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getMentee() {
        return mentee;
    }

    public void setMentee(String mentee) {
        this.mentee = mentee;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
