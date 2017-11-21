package calculator.service.validation;

import calculator.domain.ComplexObject;

public class TwoValidationServiceImpl implements ValidationService {
    public void validate(ComplexObject object) {
        boolean passingCheck = object.getValueA() > 0 && object.getValueB() > 0;
        if (!passingCheck) {
            throw new IllegalArgumentException("valueA and valueB must be positive.");
        }
    }
}
