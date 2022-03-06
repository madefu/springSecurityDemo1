package com.madefu.spd1.mybatis.generator.type.handler;

import com.madefu.spd1.mybatis.generator.type.UnitWindowType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(UnitWindowType[].class)
public class UnitWinArrayTypeHandler extends JsonArrayTypeHandler<UnitWindowType> {

    public UnitWinArrayTypeHandler(Class<UnitWindowType[]> type) {
        super(type);
    }

}
