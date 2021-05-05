package com.tms.model;


import java.util.Date;

public class Municipality {
    private int Municipality_id;
    private String MunicipalityName;
    private String CreatedBy;
    private String ModifiedBy;
    private Date CreatedDate;
    private Date ModifiedDate;

    /* Constructors*/
    public Municipality(int Municipality_id){
    }
    public Municipality(String MunicipalityName){
        this.MunicipalityName=MunicipalityName;
    }
    public Municipality(int Municipality_id,String MunicipalityName){
        this.Municipality_id=Municipality_id;
        this.MunicipalityName=MunicipalityName;
    }

    public Municipality(int municipality_id, String municipalityName, String createdBy, String modifiedBy, Date createdDate, Date modifiedDate) {
        this.Municipality_id = municipality_id;
        this.MunicipalityName = municipalityName;
        this.CreatedBy = createdBy;
        this.ModifiedBy = modifiedBy;
        this.CreatedDate = createdDate;
        this.ModifiedDate = modifiedDate;
    }

    /*Here is getter*/
    public int getMunicipality_id(){
        return  Municipality_id;
    }
    public String getMunicipalityName(){
        return  MunicipalityName;
    }
    public String getCreatedBy(){
        return CreatedBy;
    }
    public String getModifiedBy(){
        return ModifiedBy;
    }
    public Date getCreatedDate(){
        return CreatedDate;
    }
    public Date getModifiedDate(){
        return ModifiedDate;
    }

    /*Here is Setter*/
    public void setMunicipality_id(int Municipality_id){
        this.Municipality_id=Municipality_id;
    }
    public void setMunicipalityName(String MunicipalityName){
        this.MunicipalityName=MunicipalityName;
    }
    public void setCreatedBy(String CreatedBy){
        this.CreatedBy=CreatedBy;
    }
    public void setModifiedBy(String ModifiedBy){
        this.ModifiedBy=ModifiedBy;
    }
    public void setCreatedDate(Date CreatedDate){
        this.CreatedDate=CreatedDate;
    }
    public void setModifiedDate(Date ModifiedDate){
        this.ModifiedDate=ModifiedDate;
    }

}
