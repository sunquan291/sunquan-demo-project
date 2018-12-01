package com.zte.sunquan.jackson.demo2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@ToString
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "type")
public class Car implements Veticle {

    @NonNull
    private String carName;

}
