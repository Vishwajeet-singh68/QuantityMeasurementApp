package com.QuantityMeasurementApp.reposistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.QuantityMeasurementApp.config.DatabaseConnection;
import com.QuantityMeasurementApp.model.QuantityMeasurementEntity;

public class QuantityMeasurementRepository implements IQuantityMeasurementRepository {

    private static final String INSERT_QUERY =
            "INSERT INTO quantity_measurement_entity " +
            "(this_value, this_unit, that_value, that_unit, operation, result_value, result_unit) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    @Override
    public void save(QuantityMeasurementEntity entity) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {

            statement.setDouble(1, entity.thisValue);
            statement.setString(2, entity.thisUnit);
            statement.setDouble(3, entity.thatValue);
            statement.setString(4, entity.thatUnit);
            statement.setString(5, entity.operation);
            statement.setDouble(6, entity.resultValue);
            statement.setString(7, entity.resultUnit);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Quantity Measurement saved successfully.");
            }

        } catch (SQLException e) {
            System.err.println("Error saving quantity measurement");
            e.printStackTrace();
        }
    }
}