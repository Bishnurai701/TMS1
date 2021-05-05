package com.tms.model;

public class State {
    private int State_id;
    private String StateName;

    /*Constructor*/
    public State(int State_id){}

    public State(String StateName){
        this.StateName=StateName;
    }

    public State(int State_id,String StateName){
        this.State_id=State_id;
        this.StateName=StateName;
    }
    /*Here is getter*/
    public int getState_id(){
        return State_id;
    }
    public String getStateName(){
        return StateName;
    }

    /*Here is setter*/
    public void setState_id(int State_id){
        this.State_id=State_id;
    }
    public void setStateName(String StateName){
        this.StateName=StateName;
    }


}
