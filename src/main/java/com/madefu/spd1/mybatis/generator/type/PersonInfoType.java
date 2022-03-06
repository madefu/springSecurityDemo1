package com.madefu.spd1.mybatis.generator.type;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonInfoType {

    PersonInfoAddress address;
    int familyMembers;
    String realName;
    String personId;

}
