package ru.geekbrains.Lesson_3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PersonMapper {
    private final Connection connection;

    private Map<String, Object> identityMap = new ConcurrentHashMap<>();

    public PersonMapper(Connection connection) {
        this.connection = connection;
    }

    public Object findById(int personId, Class<?> aClass) {
        String personKey = aClass.getSimpleName() + personId;
        if (identityMap.containsKey(personKey)) return identityMap.get(personKey);

        PreparedStatement statement = null;
        try {
            String query = String.format("SELECT ID, NAME FROM %s WHERE ID = %d;", aClass.getSimpleName(), personId);
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Object person = personBuilderFromResultSet(aClass, resultSet);
                identityMap.put(personKey, person);
                return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Object> selectAll(Connection connection, Class<?> aClass) {

        String query = String.format("SELECT * FROM %s;", aClass.getSimpleName());
        Statement statement = null;
        List<Object> objects = new ArrayList<>();
        Object person = null;
        String personKey = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                person = personBuilderFromResultSet(aClass, resultSet);
                personKey = aClass.getSimpleName() + (resultSet.getString(0));
                objects.add(person);
                identityMap.put(personKey, person);
            }
            return objects;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private Object personBuilderFromResultSet(Class<?> aClass, ResultSet resultSet) {
        try {
            Object person = aClass.newInstance();
            Method setterId = aClass.getMethod("setId", int.class);
            Method setterName = aClass.getMethod("setName", String.class);
            setterId.invoke(person, Integer.parseInt(resultSet.getString(0)));
            setterName.invoke(person, resultSet.getString(1));
            return person;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

