package com.ask.objects;

public class BillingAddress {
    private String firstNameFld;
    private String lastNameFld;

    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


    private String stateName;

    private String streetAddressFld;
    private String cityFld;
    private String zipFld;
    private String emailFld;

    public BillingAddress(){}

    public BillingAddress(String firstNameFld, String lastNameFld,String countryName,String stateName, String streetAddressFld, String cityFld, String zipFld, String emailFld){
        this.firstNameFld=firstNameFld;
        this.lastNameFld=lastNameFld;
        this.countryName=countryName;
        this.stateName= stateName;
        this.streetAddressFld=streetAddressFld;
        this.cityFld= cityFld;
        this.zipFld=zipFld;
        this.emailFld=emailFld;

    }


    public String getFirstNameFld() {
        return firstNameFld;
    }


    public String getLastNameFld() {
        return lastNameFld;
    }


    public String getStateName() {
        return stateName;
    }


    public String getStreetAddressFld() {
        return streetAddressFld;
    }


    public String getCityFld() {
        return cityFld;
    }


    public String getZipFld() {
        return zipFld;
    }


    public String getEmailFld() {
        return emailFld;
    }









}
