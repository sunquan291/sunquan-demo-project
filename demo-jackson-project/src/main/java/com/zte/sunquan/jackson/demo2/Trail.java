package com.zte.sunquan.jackson.demo2;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
@NoArgsConstructor(staticName = "of")
@Accessors(chain = true)
@ToString(callSuper = true)
public class Trail {
    private String userName;

    //private Class type;
    private Veticle veticle;
}
