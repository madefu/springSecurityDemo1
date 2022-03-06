package com.madefu.spd1.mybatis.generator.type.handler;

import com.madefu.spd1.mybatis.generator.type.SexType;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(SexType.class)
public class SexTypeTypeHandler extends EnumOrdinalTypeHandler<SexType> {

    public SexTypeTypeHandler(Class<SexType> type) {
        super(type);
    }

}
