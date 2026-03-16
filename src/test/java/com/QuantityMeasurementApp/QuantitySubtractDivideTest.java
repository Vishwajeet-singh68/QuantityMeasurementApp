package com.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.QuantityMeasurementApp.model.Quantity;
import com.QuantityMeasurementApp.unit.VolumeUnit;
import com.QuantityMeasurementApp.unit.WeightUnit;

public class QuantitySubtractDivideTest {

    @Test
    public void subtractVolumeLitersAndMilliliters() {
        Quantity<VolumeUnit> q1 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = q1.subtract(q2);

        assertEquals(1.5, result.getValue());
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    public void subtractVolumeLitersAndMillilitersInTargetUnit() {
        Quantity<VolumeUnit> q1 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = q1.subtract(q2, VolumeUnit.MILLILITRE);

        assertEquals(1500, result.getValue());
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    public void subtractWeightKilogramsAndGrams() {
        Quantity<WeightUnit> q1 = new Quantity<>(2.0, WeightUnit.KILOGRAMS);
        Quantity<WeightUnit> q2 = new Quantity<>(500.0, WeightUnit.GRAMS);

        Quantity<WeightUnit> result = q1.subtract(q2);

        assertEquals(1.5, result.getValue());
        assertEquals(WeightUnit.KILOGRAMS, result.getUnit());
    }

    @Test
    public void subtractWeightKilogramsAndGramsInTargetUnit() {
        Quantity<WeightUnit> q1 = new Quantity<>(2.0, WeightUnit.KILOGRAMS);
        Quantity<WeightUnit> q2 = new Quantity<>(500.0, WeightUnit.GRAMS);

        Quantity<WeightUnit> result = q1.subtract(q2, WeightUnit.GRAMS);

        assertEquals(1500, result.getValue());
        assertEquals(WeightUnit.GRAMS, result.getUnit());
    }

    @Test
    public void preventSubtractNullQuantity() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);

        assertThrows(IllegalArgumentException.class, () -> q1.subtract(null));
    }

    @Test
    public void divideVolumeLitersByMilliliters() {
        Quantity<VolumeUnit> q1 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        double result = q1.division(q2).getValue();

        assertEquals(4.0, result);
    }

    @Test
    public void divideWeightKilogramsByGrams() {
        Quantity<WeightUnit> q1 = new Quantity<>(2.0, WeightUnit.KILOGRAMS);
        Quantity<WeightUnit> q2 = new Quantity<>(500.0, WeightUnit.GRAMS);

        double result = q1.division(q2).getValue();

        assertEquals(4.0, result);
    }

    @Test
    public void divideVolumeByScalarInSameUnit() {
        Quantity<VolumeUnit> q = new Quantity<>(2.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = q.division(new Quantity<>(2.0, VolumeUnit.LITRE), VolumeUnit.LITRE);

        assertEquals(1.0, result.getValue());
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    public void divideVolumeByScalarInTargetUnit() {
        Quantity<VolumeUnit> q = new Quantity<>(2.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = q.division(new Quantity<>(2.0, VolumeUnit.LITRE), VolumeUnit.LITRE);

        assertEquals(1000, result.getValue());
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    public void preventDivideByZeroScalar() {
        Quantity<VolumeUnit> q = new Quantity<>(2.0, VolumeUnit.LITRE);

        assertThrows(ArithmeticException.class, () -> q.division(new Quantity<>(0.0, VolumeUnit.LITRE), VolumeUnit.LITRE));
    }

    @Test
    public void preventDivideByNullQuantity() {
        Quantity<VolumeUnit> q = new Quantity<>(2.0, VolumeUnit.LITRE);

        assertThrows(IllegalArgumentException.class, () -> q.division(null));
    }
}
