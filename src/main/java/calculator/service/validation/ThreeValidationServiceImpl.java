package calculator.service.validation;

import calculator.domain.ComplexObject;

public class ThreeValidationServiceImpl implements ValidationService {
    public void validate(ComplexObject object) {
        boolean passingCheck = (object.getValueA() == -100 || object.getValueA() == 50) && object.getValueB() < 0;
        if (!passingCheck) {
            throw new IllegalArgumentException("valueA must be -100 ir 50. valueB must be negative.");
        }
    }
}
