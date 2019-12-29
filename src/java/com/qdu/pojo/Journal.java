package com.qdu.pojo;
// Generated 2019-1-1 18:49:23 by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Journal generated by hbm2java
 */
@Entity
@Table(name="journal"
    ,schema="dbo"
    ,catalog="SptEducation"
)
public class Journal  implements java.io.Serializable {


     private JournalId id;
     private String speTitle;
     private String jourContent;
     private String jourAbout;

    public Journal() {
    }

	
    public Journal(JournalId id) {
        this.id = id;
    }
    public Journal(JournalId id, String speTitle, String jourContent, String jourAbout) {
       this.id = id;
       this.speTitle = speTitle;
       this.jourContent = jourContent;
       this.jourAbout = jourAbout;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="jourTime", column=@Column(name="JourTime", nullable=false, length=23) ), 
        @AttributeOverride(name="userId", column=@Column(name="UserId", nullable=false, length=30) ) } )
    public JournalId getId() {
        return this.id;
    }
    
    public void setId(JournalId id) {
        this.id = id;
    }

    
    @Column(name="SpeTitle", length=50)
    public String getSpeTitle() {
        return this.speTitle;
    }
    
    public void setSpeTitle(String speTitle) {
        this.speTitle = speTitle;
    }

    
    @Column(name="JourContent", length=1000)
    public String getJourContent() {
        return this.jourContent;
    }
    
    public void setJourContent(String jourContent) {
        this.jourContent = jourContent;
    }

    
    @Column(name="JourAbout", length=1000)
    public String getJourAbout() {
        return this.jourAbout;
    }
    
    public void setJourAbout(String jourAbout) {
        this.jourAbout = jourAbout;
    }




}


