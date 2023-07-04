package org.example;

public class University {
    String id;
    String fullName;
    String shortName;
    int yearOfFoundation;
    StudyProfile mainProfile;


    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile StudyProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        mainProfile = StudyProfile;

    }
}
enum   StudyProfile {
    dispatcher("диспетчер"),
    constructor("конструктор"),
    engineer("инженер");

    private String transcripts;
    StudyProfile(String transcripts){
        this.transcripts = transcripts;
    }
    public String gettranscripts(){ return transcripts;}

}
