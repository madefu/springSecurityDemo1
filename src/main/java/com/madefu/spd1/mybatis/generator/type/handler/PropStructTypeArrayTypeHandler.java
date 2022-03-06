package com.madefu.spd1.mybatis.generator.type.handler;

import com.madefu.spd1.mybatis.generator.type.PropStructType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(PropStructType[].class)
public class PropStructTypeArrayTypeHandler extends EnumOrdinalArrayTypeHandler<PropStructType> {

    public PropStructTypeArrayTypeHandler(Class<PropStructType[]> type) {
        super(type);
    }

}
