package com.gangplank.ruralconnect.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(suppressConstructorProperties=true)
@NoArgsConstructor
@Getter
public class Scheme {

    private String name;
    private String department;
    private String beneficiaries;
    private String funding_pattern;
    private String jurisdiction;
    private String age_eligible;
    private String income_eligible;
    private String others_eligible;
    private String avail_from;
    private String valid_from;
    private String valid_till;
    private String description;

}
