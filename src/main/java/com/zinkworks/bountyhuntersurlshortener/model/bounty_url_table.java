package com.zinkworks.bountyhuntersurlshortener.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

// @entity and @table creates the table in the database - 'bounty_url_table'.
@Entity
@Table
public class bounty_url_table {


    // Declares primary key for ID column. Generates a sequence of id's for each url.
    @Id
    @SequenceGenerator(name="url_id_sequence", sequenceName = "url_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "url_id_sequence")
    private Long id;
    private String original_url;
    private String short_url;
    private OffsetDateTime created_date;

    // constructor
    public bounty_url_table(Long id, String original_url, String short_url, OffsetDateTime created_date) {
        this.id = id;
        this.original_url = original_url;
        this.short_url = short_url;
        this.created_date = created_date;
    }

    // no arguments constructor
    public bounty_url_table() {
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public OffsetDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(OffsetDateTime created_date) {
        this.created_date = created_date;
    }

    // Displays on our webpage.
    @Override
    public String toString() {
        return "bounty_url_table{" +
                "id=" + id +
                ", original_url='" + original_url + '\'' +
                ", short_url='" + short_url + '\'' +
                ", created_date=" + created_date +
                '}';
    }
}


