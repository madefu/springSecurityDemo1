package com.madefu.spd1.mybatis.generator.type.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JsonObjectTypeHandler<E> extends BaseTypeHandler<E> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final Class<E> type;

    static {
        // Ignore outputting null value when serializing
        OBJECT_MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
    }

    public JsonObjectTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType)
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
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        try {
            return parseJsonObject(resultSet.getString(s));
        } catch (JsonProcessingException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        try {
            return parseJsonObject(resultSet.getString(i));
        } catch (JsonProcessingException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        try {
            return parseJsonObject(callableStatement.getString(i));
        } catch (JsonProcessingException e) {
            throw new SQLException(e);
        }
    }

    private E parseJsonObject(String jsonObject) throws JsonProcessingException {
        if (jsonObject != null) {
            if (jsonObject.isBlank()) {
                return null;
            }
            return OBJECT_MAPPER.readValue(jsonObject, type);
        }
        return null;
    }

}
