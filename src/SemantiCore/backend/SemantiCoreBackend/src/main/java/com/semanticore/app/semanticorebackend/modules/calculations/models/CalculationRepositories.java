package com.semanticore.app.semanticorebackend.modules.calculations.models;

import org.springframework.stereotype.Component;

@Component
public class CalculationRepositories {

    // OEE Calculation: Takes availability, performance, and quality
    public double calculateOEE(double availability, double performance, double quality) {
        return (availability * performance * quality) / 10000;
    }

    // TCO Calculation: Takes acquisition cost, operating cost, and maintenance cost
    public double calculateTCO(double acquisitionCost, double operatingCost, double maintenanceCost) {
        return acquisitionCost + operatingCost + maintenanceCost;
    }

    // MTBF Calculation: Takes total operational time and number of failures
    public double calculateMTBF(double totalOperationalTime, int numberOfFailures) {
        return totalOperationalTime / numberOfFailures;
    }

    // MTTR Calculation: Takes total repair time and number of repairs
    public double calculateMTTR(double totalRepairTime, int numberOfRepairs) {
        return totalRepairTime / numberOfRepairs;
    }

    // Yield Calculation: Takes the number of good products and total products produced
    public double calculateYield(int goodProducts, int totalProducts) {
        return ((double) goodProducts / totalProducts) * 100;
    }

    // Throughput Calculation: Takes total products processed and processing time (in hours)
    public double calculateThroughput(int totalProducts, double processingTimeHours) {
        return totalProducts / processingTimeHours;
    }

    // Cpk Calculation: Takes process mean, target value, standard deviation, and tolerance limit
    public double calculateCpk(double processMean, double targetValue, double standardDeviation, double toleranceLimit) {
        double upperCpk = (toleranceLimit - processMean) / (3 * standardDeviation);
        double lowerCpk = (processMean - targetValue) / (3 * standardDeviation);
        return Math.min(upperCpk, lowerCpk);
    }

    // RTY Calculation: Takes yield for each stage of the process
    public double calculateRTY(double[] stageYields) {
        double rty = 1.0;
        for (double yield : stageYields) {
            rty *= yield / 100;
        }
        return rty * 100;
    }

    // Cycle Time Calculation: Takes total production time and number of units produced
    public double calculateCycleTime(double totalProductionTime, int totalUnitsProduced) {
        return totalProductionTime / totalUnitsProduced;
    }

    // SCRAP Calculation: Takes number of defective units and total units produced
    public double calculateSCRAP(int defectiveUnits, int totalUnitsProduced) {
        return ((double) defectiveUnits / totalUnitsProduced) * 100;
    }

    // Capacity Utilization: Takes actual output and maximum potential output
    public double calculateCapacityUtilization(double actualOutput, double maxOutput) {
        return (actualOutput / maxOutput) * 100;
    }

    // Takt Time Calculation: Takes available production time and customer demand
    public double calculateTaktTime(double availableProductionTime, int customerDemand) {
        return availableProductionTime / customerDemand;
    }

    // Downtime Calculation: Takes total downtime and total production time
    public double calculateDowntime(double totalDowntime, double totalProductionTime) {
        return (totalDowntime / totalProductionTime) * 100;
    }

    // Energy Efficiency: Takes energy consumed and number of units produced
    public double calculateEnergyEfficiency(double energyConsumed, int totalUnitsProduced) {
        return totalUnitsProduced / energyConsumed;
    }

    // Lead Time: Takes the time taken to receive an order and deliver the product
    public double calculateLeadTime(double timeToReceiveOrder, double timeToDeliverProduct) {
        return timeToDeliverProduct - timeToReceiveOrder;
    }
}
