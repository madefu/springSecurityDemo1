package com.madefu.spd1.mybatis.generator.type.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public abstract class EnumOrdinalArrayTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E[]> {

    private final Class<E[]> type;
    private final E[] enums;

    public EnumOrdinalArrayTypeHandler(Class<E[]> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        this.enums = (E[]) type.getComponentType().getEnumConstants();
        if (this.enums == null) {
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum array type.");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E[] es, JdbcType jdbcType)
        throws SQLException {
        Short[] os = new Short[es.length];
        for (int m = 0; m < es.length; m++) {
            os[m] = (short) es[m].ordinal();
        }
        Array array = preparedStatement.getConnection().createArrayOf("smallint", os);
        preparedStatement.setArray(i, array);
    }

    @Override
    public E[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return extractEnumArrayFromOrdinalArray(resultSet.getArray(s));
    }

    @Override
    public E[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return extractEnumArrayFromOrdinalArray(resultSet.getArray(i));
    }

    @Override
    public E[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return extractEnumArrayFromOrdinalArray(callableStatement.getArray(i));
    }

    private E[] extractEnumArrayFromOrdinalArray(Array array) throws SQLException {
        if (array == null) {
            return null;
        }
        Short[] ordinalArray = (Short[]) array.getArray();

        //noinspection unchecked
        E[] enumArray = (E[]) java.lang.reflect.Array.newInstance(type.getComponentType(), ordinalArray.length);
        for (int i = 0; i < ordinalArray.length; i++) {
            if (ordinalArray[i] == null) {
                throw new SQLException("A null value cannot be mapped to any enum constants in " +
                    type.getComponentType().getSimpleName());
            }
            E value = toOrdinalEnum(ordinalArray[i]);
            enumArray[i] = value;
        }
        array.free();
        return enumArray;
    }

    private E toOrdinalEnum(int ordinal) {
        try {
            return enums[ordinal];
        } catch (Exception ex) {
            throw new IllegalArgumentException(
                "Cannot convert " + ordinal + " to " +
                    type.getComponentType().getSimpleName() +
                    " by ordinal value.",
                ex);
        }
    }

}
