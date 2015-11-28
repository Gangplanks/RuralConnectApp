package com.gangplank.ruralconnect.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(suppressConstructorProperties=true)
@NoArgsConstructor
public class SchemeFilterResponse {
    private int id;
    private String name;
    private String icon;
}
