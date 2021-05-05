package com.tms.model;

public class AddressType {
    private int AddressType_id;
    private String AddressTypeName;

    /* here is constructors */
    public AddressType(int AddressType_id){}
    public AddressType(int AddressType_id,String AddressTypename){
        this.AddressType_id=AddressType_id;
        this.AddressTypeName=AddressTypename;
    }
    public AddressType(String AddressTypeName){
        this.AddressTypeName=AddressTypeName;
    }

    /*Here is getter */

    public int getAddressType_id() {
        return AddressType_id;
    }

    public String getAddressTypeName() {
        return AddressTypeName;
    }

    /* here is setter */

    public void setAddressType_id(int AddressType_id) {
        this.AddressType_id = AddressType_id;
    }

    public void setAddressTypeName(String AddressTypeName) {
        this.AddressTypeName = AddressTypeName;
    }
}
