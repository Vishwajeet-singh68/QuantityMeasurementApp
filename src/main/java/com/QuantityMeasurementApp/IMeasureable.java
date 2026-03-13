package com.QuantityMeasurementApp;

@FunctionalInterface
interface SupportsArithmetic {
    boolean isSupported();
}

public interface IMeasureable {

    double convertToBaseUnit(double value);

    double getConversionFactor();
    
    double convertFromBaseUnit(double value);

    SupportsArithmetic supportsArithmetic = () -> true;

    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    default void validateOperationSupport(String operation) {
        if (!supportsArithmetic()) {
            throw new UnsupportedOperationException(
                    "Operation " + operation + " is not supported for this measurement type."
            );
        }
    }
}