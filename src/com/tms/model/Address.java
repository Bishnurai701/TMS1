package com.tms.model;

public class Address {

    private int Address_id;
    private int AddressType_id;
    private int Registration_id;
    private String Address_MunicipalityName;
    private int Municipality_id;
    private String StreetName;
    private int WardNo;
    private int Country_id;
    private int State_id;
    private int District_id;
    private String CityName;


    private String AddressTypeName;
    private String FirstName;
    private String StateName;
    private String DistrictName;
    private String MunicipalityName;
    private String CountryName;



    /* Constructors */
    public Address(int Country_id,String CountryName){
        this.Country_id=Country_id;
        this.CountryName=CountryName;
    }
    public Address(int Address_id){}
    public Address(int Address_id,int AddressType_id, int Registration_id, String Address_MunicipalityName,int Municipality_id,
                   String StreetName, int WardNo,int Country_id, int State_id, int District_id,String CityName)
    {
       this.Address_id=Address_id;
       this.AddressType_id=AddressType_id;
       this.Address_MunicipalityName=Address_MunicipalityName;
       this.Municipality_id=Municipality_id;
       this.Registration_id=Registration_id;
       this.StreetName=StreetName;
       this.WardNo=WardNo;
       this.Country_id=Country_id;
       this.State_id=State_id;
       this.District_id=District_id;
       this.CityName=CityName;

    }

    public Address(int AddressType_id, int Registration_id, String Address_MunicipalityName,int Municipality_id,
                   String StreetName, int WardNo,int Country_id, int State_id, int District_id,String CityName)
    {
        this.AddressType_id=AddressType_id;
        this.Address_MunicipalityName=Address_MunicipalityName;
        this.Municipality_id=Municipality_id;
        this.Registration_id=Registration_id;
        this.StreetName=StreetName;
        this.WardNo=WardNo;
        this.Country_id=Country_id;
        this.State_id=State_id;
        this.District_id=District_id;
        this.CityName=CityName;

    }
    public Address(int Address_id,String AddressTypeName, String FirstName, String Address_MunicipalityName, String StreetName,
                   int WardNo, String StateName, String DistrictName, String MunicipalityName,
                   String CountryName,String CityName)
    {
        this.Address_id=Address_id;
        this.AddressTypeName=AddressTypeName;
        this.FirstName=FirstName;
        this.Address_MunicipalityName=Address_MunicipalityName;
        this.StreetName=StreetName;
        this.WardNo=WardNo;
        this.StateName=StateName;
        this.DistrictName=DistrictName;
        this.MunicipalityName=MunicipalityName;
        this.CountryName=CountryName;
        this.CityName=CityName;
    }


    /* Here is Getter */

    public int getAddress_id() {
        return Address_id;
    }

    public int getAddressType_id() {
        return AddressType_id;
    }

    public int getRegistration_id() {
        return Registration_id;
    }

    public String getAddress_MunicipalityName() {
        return Address_MunicipalityName;
    }

    public int getMunicipality_id() {
        return Municipality_id;
    }

    public String getStreetName() {
        return StreetName;
    }

    public int getWardNo() {
        return WardNo;
    }

    public int getCountry_id() {
        return Country_id;
    }

    public int getState_id() {
        return State_id;
    }

    public int getDistrict_id() {
        return District_id;
    }
    public String getAddressTypeName(){return AddressTypeName;}

    public String getFirstName() {
        return FirstName;
    }

    public String getStateName() {
        return StateName;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public String getMunicipalityName() {
        return MunicipalityName;
    }

    public String getCountryName() {
        return CountryName;
    }
    public String getCityName(){return CityName;}
    /* Here is Setter */

    public void setAddress_id(int Address_id) {
        this.Address_id = Address_id;
    }

    public void setAddressType_id(int AddressType_id) {
        this.AddressType_id = AddressType_id;
    }

    public void setRegistration_id(int Registration_id) {
        this.Registration_id = Registration_id;
    }

    public void setAddress_MunicipalityName(String Address_MunicipalityName) {
        this.Address_MunicipalityName = Address_MunicipalityName;
    }

    public void setMunicipality_id(int Municipality_id) {
        this.Municipality_id = Municipality_id;
    }

    public void setStreetName(String StreetName) {
        this.StreetName = StreetName;
    }

    public void setWardNo(int WardNo) {
        this.WardNo = WardNo;
    }

    public void setCountry_id(int Country_id) {
        this.Country_id = Country_id;
    }

    public void setState_id(int State_id) {
        this.State_id = State_id;
    }

    public void setDistrict_id(int District_id) {
        this.District_id = District_id;
    }
    public void setAddressTypeName(String AddressTypeName){this.AddressTypeName=AddressTypeName;}

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setStateName(String StateName) {
        this.StateName = StateName;
    }

    public void setDistrictName(String DistrictName) {
        this.DistrictName = DistrictName;
    }

    public void setMunicipalityName(String MunicipalityName) {
        this.MunicipalityName = MunicipalityName;
    }

    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    public void setCityName(String CityName){this.CityName=CityName;}
}
