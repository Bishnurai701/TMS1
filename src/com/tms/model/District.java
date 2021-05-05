package com.tms.model;

public class District {
    private int District_id;
    private String DistrictName;

    /* Constructor */
    public District(int District_id){}
    public District(int District_id,String DistrictName){
        this.District_id=District_id;
        this.DistrictName=DistrictName;
    }
    public District(String DistrictName){
        this.DistrictName=DistrictName;
    }

    /* Here is Getter*/

    public int getDistrict_id(){
        return District_id;
    }
    public String  getDistrictName(){
        return DistrictName;
    }

    /* Here is Setter*/
    public void setDistrict_id(int District_id){
        this.District_id=District_id;
    }
    public void setDistrictName(String DistrictName){
        this.DistrictName=DistrictName;
    }


}
