package com.bloomtech.welcomeletter.models;

public class Company {
    private static int maxId = 1;
    private int id;

    private String companyname;
    private String country;

    public static CompanyBuilder builder() {
        return new CompanyBuilder();
    }

    //TODO: Replace with Builder Constructor
    private Company(CompanyBuilder builder) {
        //Auto-generate an id
        id = maxId;
        maxId++;

        //Initialize fields
        this.companyname = builder.companyname;
        this.country = builder.country;
    }

    public static final class CompanyBuilder {
        //TODO: Implement Builder Pattern
        private static int maxId = 1;
        private int id;

        private String companyname;
        private String country;

        public CompanyBuilder() {
            this.id = maxId;
            maxId++;
        }

        public CompanyBuilder withCompanyname(String companyname) {
            this.companyname = companyname;
            return this;
        }

        public CompanyBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Company build() {
            return new Company(this);

        }
    }

    public int getId() {
        return id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getCountry() {
        return country;
    }
}
