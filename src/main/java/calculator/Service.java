package calculator;

import calculator.service.validation.OneValidationServiceImpl;
import calculator.service.validation.ThreeValidationServiceImpl;
import calculator.service.validation.TwoValidationServiceImpl;
import calculator.service.validation.ValidationService;

public enum Service {
    ONE(new OneValidationServiceImpl()),
    TWO(new TwoValidationServiceImpl()),
    THREE(new ThreeValidationServiceImpl());

    private ValidationService validationService;

    Service(ValidationService validationService) {
        this.validationService = validationService;
    }

    public ValidationService getValidationService() {
        return validationService;
    }
}
