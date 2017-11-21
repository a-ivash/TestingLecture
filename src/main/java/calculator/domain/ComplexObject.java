package calculator.domain;

import calculator.Service;

public class ComplexObject {
    private int valueA;
    private int valueB;
    private Service service = Service.ONE; // by default

    public ComplexObject() {
    }

    public ComplexObject(int valueA, int valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }

    public ComplexObject(int valueA, int valueB, Service service) {
        this(valueA, valueB);
        this.service = service;
    }

    public int getValueA() {
        return valueA;
    }

    public void setValueA(int valueA) {
        this.valueA = valueA;
    }

    public int getValueB() {
        return valueB;
    }

    public void setValueB(int valueB) {
        this.valueB = valueB;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplexObject that = (ComplexObject) o;

        if (valueA != that.valueA) return false;
        return valueB == that.valueB;

    }

    @Override
    public int hashCode() {
        int result = valueA;
        result = 31 * result + valueB;
        return result;
    }

    @Override
    public String toString() {
        return String.format("[valueA=%d, valueB=%d]", valueA, valueB);
    }
}
