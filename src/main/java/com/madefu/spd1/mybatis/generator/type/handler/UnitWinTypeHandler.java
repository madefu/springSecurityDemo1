package com.madefu.spd1.mybatis.generator.type.handler;

import com.madefu.spd1.mybatis.generator.type.UnitWindowType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(UnitWindowType.class)
public class UnitWinTypeHandler extends JsonObjectTypeHandler<UnitWindowType> {

    public UnitWinTypeHandler(Class<UnitWindowType> type) {
        super(type);
    }

}
