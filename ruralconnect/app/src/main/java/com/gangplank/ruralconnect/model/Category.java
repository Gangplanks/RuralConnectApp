package com.gangplank.ruralconnect.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(suppressConstructorProperties=true)
@NoArgsConstructor
public class Category {
    private int id;
    private String name;
    private String imageName;
    private String url;
}
