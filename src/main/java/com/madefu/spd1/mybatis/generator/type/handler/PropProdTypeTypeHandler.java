package com.madefu.spd1.mybatis.generator.type.handler;

import com.madefu.spd1.mybatis.generator.type.PropProdType;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(PropProdType.class)
public class PropProdTypeTypeHandler extends EnumOrdinalTypeHandler<PropProdType> {

    public PropProdTypeTypeHandler(Class<PropProdType> type) {
        super(type);
    }

}
