package com.QuantityMeasurementApp;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasureable {

    CELSIUS(
            c -> c,
            c -> c
    ),

    FAHRENHEIT(
            f -> (f - 32) * 5 / 9,
            c -> (c * 9 / 5) + 32
    );

    private final Function<Double, Double> toBase;
    private final Function<Double, Double> fromBase;

    TemperatureUnit(Function<Double, Double> toBase,
                    Function<Double, Double> fromBase) {
        this.toBase = toBase;
        this.fromBase = fromBase;
    }

    // temperature does not support arithmetic
    private final SupportsArithmetic supportsArithmetic = () -> false;

    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
                "Temperature does not support arithmetic operation: " + operation
        );
    }

    @Override
    public double convertToBaseUnit(double value) {
        return toBase.apply(value);
    }

    public double convertFromBaseUnit(double base) {
        return fromBase.apply(base);
    }

    @Override
    public double getConversionFactor() {
        return 1; // unused for temperature
    }
}
