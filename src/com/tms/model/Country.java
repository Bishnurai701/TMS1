package com.tms.model;

public class Country {
private int Country_id;
private int CountryCode;
private String CountryName;
private int Registration_id;
private int PermanentAddress_id;
private int TemporaryAddress_id;

/*Constructor*/
public Country(int Country_id){
}
public Country(int Country_id, int CountryCode,String CountryName){
   this.Country_id=Country_id;
   this.CountryCode=CountryCode;
   this.CountryName=CountryName;
}

public Country(int CountryCode,String CountryName){
  this.CountryCode=CountryCode;
  this.CountryName=CountryName;
}

/*Here is Getter*/
   public int getCountry_id(){
       return Country_id;
   }
   public int getCountryCode(){
       return CountryCode;
   }
   public String getCountryName(){
       return CountryName;
   }

    /*here is setter*/
   public void setCountry_id(int Country_id){
       this.Country_id=Country_id;
   }
   public void setCountryCode(int CountryCode){
       this.CountryCode=CountryCode;
   }
   public void setCountryName(String CountryName){
       this.CountryName=CountryName;
   }




}
