package com.madefu.spd1.mybatis.generator.type.handler;

import com.madefu.spd1.mybatis.generator.type.PersonInfoType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(PersonInfoType.class)
public class PersonInfoTypeHandler extends JsonObjectTypeHandler<PersonInfoType>{

    public PersonInfoTypeHandler(Class<PersonInfoType> type) {
        super(type);
    }
}
