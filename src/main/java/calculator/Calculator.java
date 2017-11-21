package calculator;

import calculator.domain.ComplexObject;
import calculator.service.CountingService;
import calculator.service.StatisticService;

public class Calculator {
    private CountingService countingService;
    private StatisticService statisticsService;

    public void setCountingService(CountingService countingService) {
        this.countingService = countingService;
    }

    public void setStatisticsService(StatisticService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public StatisticService getStatisticsService() {
        return statisticsService;
    }

    public ComplexObject add(ComplexObject param1, ComplexObject param2) {
        statisticsService.incrementAddCounter();
        checkParameters(param1, param2);
        return countingService.add(param1, param2);
    }

    public ComplexObject subtract(ComplexObject param1, ComplexObject param2) {
        statisticsService.incrementSubtractCounter();
        checkParameters(param1, param2);
        return countingService.subtract(param1, param2);
    }

    public ComplexObject multiply(ComplexObject param1, ComplexObject param2) {
        statisticsService.incrementMultiplyCounter();
        checkParameters(param1, param2);
        return countingService.multiply(param1, param2);
    }

    public ComplexObject divide(ComplexObject param1, ComplexObject param2) {
        statisticsService.incrementDivideCounter();
        checkParameters(param1, param2);
        return countingService.divide(param1, param2);
    }


    private void checkParameters(ComplexObject param1, ComplexObject param2) {
        try {
            boolean haveSameService = param1.getService().equals(param2.getService());
            if (!haveSameService) {
                throw new IllegalArgumentException("Parameters have different services");
            }
            param1.getService().getValidationService().validate(param1);
            param2.getService().getValidationService().validate(param2);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Object1 or Object2 == null");
        }
    }
}
