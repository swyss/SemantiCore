package com.semanticore.app.semanticorebackend.modules.calculations;

import com.semanticore.app.semanticorebackend.exceptions.CalculationException;
import com.semanticore.app.semanticorebackend.modules.calculations.models.CalculationRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    private static final Logger logger = LoggerFactory.getLogger(CalculationService.class);

    @Autowired
    private CalculationRepositories calculationRepositories;

    public double calculateOEE(double availability, double performance, double quality) {
        if (availability < 0 || performance < 0 || quality < 0) {
            throw new CalculationException("Availability, Performance, and Quality must be non-negative.");
        }
        return calculationRepositories.calculateOEE(availability, performance, quality);
    }

    public double calculateTCO(double acquisitionCost, double operatingCost, double maintenanceCost) {
        if (acquisitionCost < 0 || operatingCost < 0 || maintenanceCost < 0) {
            throw new CalculationException("All costs must be non-negative.");
        }
        return calculationRepositories.calculateTCO(acquisitionCost, operatingCost, maintenanceCost);
    }

    public double calculateMTBF(double totalOperationalTime, int numberOfFailures) {
        if (numberOfFailures < 0 || totalOperationalTime < 0) {
            throw new CalculationException("Total Operational Time and Number of Failures must be non-negative.");
        }
        if (numberOfFailures == 0) {
            logger.warn("Number of failures is zero, MTBF is infinity.");
            return Double.POSITIVE_INFINITY;
        }
        return calculationRepositories.calculateMTBF(totalOperationalTime, numberOfFailures);
    }

    public double calculateMTTR(double totalRepairTime, int numberOfRepairs) {
        if (numberOfRepairs == 0) {
            logger.warn("Number of repairs is zero, MTTR cannot be calculated.");
            return 0;
        }
        return calculationRepositories.calculateMTTR(totalRepairTime, numberOfRepairs);
    }

    public double calculateYield(int goodProducts, int totalProducts) {
        if (totalProducts == 0) {
            throw new CalculationException("Total products cannot be zero when calculating yield.");
        }
        return calculationRepositories.calculateYield(goodProducts, totalProducts);
    }

    public double calculateThroughput(int totalProducts, double processingTimeHours) {
        if (processingTimeHours == 0) {
            throw new CalculationException("Processing time cannot be zero when calculating throughput.");
        }
        return calculationRepositories.calculateThroughput(totalProducts, processingTimeHours);
    }

    public double calculateCpk(double processMean, double targetValue, double standardDeviation, double toleranceLimit) {
        if (standardDeviation == 0) {
            throw new CalculationException("Standard deviation cannot be zero when calculating Cpk.");
        }
        return calculationRepositories.calculateCpk(processMean, targetValue, standardDeviation, toleranceLimit);
    }

    public double calculateRTY(double[] stageYields) {
        return calculationRepositories.calculateRTY(stageYields);
    }

    public double calculateCycleTime(double totalProductionTime, int totalUnitsProduced) {
        if (totalUnitsProduced == 0) {
            throw new CalculationException("Total units produced cannot be zero when calculating cycle time.");
        }
        return calculationRepositories.calculateCycleTime(totalProductionTime, totalUnitsProduced);
    }

    public double calculateSCRAP(int defectiveUnits, int totalUnitsProduced) {
        return calculationRepositories.calculateSCRAP(defectiveUnits, totalUnitsProduced);
    }

    public double calculateCapacityUtilization(double actualOutput, double maxOutput) {
        return calculationRepositories.calculateCapacityUtilization(actualOutput, maxOutput);
    }

    public double calculateTaktTime(double availableProductionTime, int customerDemand) {
        if (customerDemand == 0) {
            throw new CalculationException("Customer demand cannot be zero when calculating takt time.");
        }
        return calculationRepositories.calculateTaktTime(availableProductionTime, customerDemand);
    }

    public double calculateDowntime(double totalDowntime, double totalProductionTime) {
        return calculationRepositories.calculateDowntime(totalDowntime, totalProductionTime);
    }

    public double calculateEnergyEfficiency(double energyConsumed, int totalUnitsProduced) {
        if (energyConsumed == 0) {
            throw new CalculationException("Energy consumed cannot be zero when calculating energy efficiency.");
        }
        return calculationRepositories.calculateEnergyEfficiency(energyConsumed, totalUnitsProduced);
    }

    public double calculateLeadTime(double timeToReceiveOrder, double timeToDeliverProduct) {
        return calculationRepositories.calculateLeadTime(timeToReceiveOrder, timeToDeliverProduct);
    }
}
