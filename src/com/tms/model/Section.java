package com.tms.model;

public class Section {
    private int Section_id;
    private String SectionName;
    private int Registration_id;
    private int Person_id;

    /* Constructor */
    public Section(int Section_id){}
    public Section(int Section_id,String SectionName){
        this.Section_id=Section_id;
        this.SectionName=SectionName;
    }
    public Section(String SectionName){
        this.SectionName=SectionName;
    }
    /*Here is Getter*/
    public int getSection_id(){
        return Section_id;
    }
    public String getSectionName(){
        return SectionName;
    }
    /*Here is Setter*/
    public void setSection_id(int Section_id){
        this.Section_id=Section_id;
    }
    public void setSectionName(String SectionName){
        this.SectionName=SectionName;
    }

}
