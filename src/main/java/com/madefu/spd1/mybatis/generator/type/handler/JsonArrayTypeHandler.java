package com.madefu.spd1.mybatis.generator.type.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.postgresql.util.PGobject;

import java.lang.reflect.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JsonArrayTypeHandler<E> extends BaseTypeHandler<E[]> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final Class<E[]> type;

    static {
        // Ignore outputting null value when serializing
        OBJECT_MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
    }

    public JsonArrayTypeHandler(Class<E[]> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E[] e, JdbcType jdbcType)
        throws SQLException {
        PGobject pgObject = new PGobject();
        pgObject.setType("jsonb");
        try {
            pgObject.setValue(OBJECT_MAPPER.writeValueAsString(e));
        } catch (JsonProcessingException exception) {
            throw new SQLException(exception);
        }
        preparedStatement.setObject(i, pgObject);
    }

    @Override
    public E[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        try {
            return parseJsonArray(resultSet.getString(s));
        } catch (JsonProcessingException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public E[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        try {
            return parseJsonArray(resultSet.getString(i));
        } catch (JsonProcessingException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public E[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        try {
            return parseJsonArray(callableStatement.getString(i));
        } catch (JsonProcessingException e) {
            throw new SQLException(e);
        }
    }

    private E[] parseJsonArray(String jsonArray) throws JsonProcessingException {
        if (jsonArray != null) {
            if (jsonArray.isBlank()) {
                //noinspection unchecked
                return (E[]) Array.newInstance(type, 0);
            }

            return OBJECT_MAPPER.readValue(jsonArray, type);
        }
        return null;
    }

}
