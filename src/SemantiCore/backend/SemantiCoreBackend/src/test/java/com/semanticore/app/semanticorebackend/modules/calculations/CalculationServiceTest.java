package com.semanticore.app.semanticorebackend.modules.calculations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationServiceTest {

    private CalculationService calculationService;

    @BeforeEach
    public void setup() {
        calculationService = new CalculationService();
    }

    @Test
    public void testCalculateOEE() {
        double availability = 95.0;
        double performance = 90.0;
        double quality = 85.0;
        double oee = calculationService.calculateOEE(availability, performance, quality);
        assertEquals(72.675, oee, 0.001);
    }

    @Test
    public void testCalculateTCO() {
        double acquisitionCost = 100000;
        double operatingCost = 50000;
        double maintenanceCost = 20000;
        double tco = calculationService.calculateTCO(acquisitionCost, operatingCost, maintenanceCost);
        assertEquals(170000, tco);
    }

    @Test
    public void testCalculateMTBF() {
        double totalOperationalTime = 1000.0;
        int numberOfFailures = 5;
        double mtbf = calculationService.calculateMTBF(totalOperationalTime, numberOfFailures);
        assertEquals(200.0, mtbf);
    }

    @Test
    public void testCalculateMTTR() {
        double totalRepairTime = 100.0;
        int numberOfRepairs = 5;
        double mttr = calculationService.calculateMTTR(totalRepairTime, numberOfRepairs);
        assertEquals(20.0, mttr);
    }

    @Test
    public void testCalculateYield() {
        int goodProducts = 950;
        int totalProducts = 1000;
        double yield = calculationService.calculateYield(goodProducts, totalProducts);
        assertEquals(95.0, yield);
    }

    @Test
    public void testCalculateThroughput() {
        int totalProducts = 1000;
        double processingTime = 10.0;
        double throughput = calculationService.calculateThroughput(totalProducts, processingTime);
        assertEquals(100.0, throughput);
    }

    @Test
    public void testCalculateCpk() {
        double processMean = 50.0;
        double targetValue = 45.0;
        double standardDeviation = 2.0;
        double toleranceLimit = 60.0;
        double cpk = calculationService.calculateCpk(processMean, targetValue, standardDeviation, toleranceLimit);
        assertEquals(1.666, cpk, 0.001);
    }

    @Test
    public void testCalculateRTY() {
        double[] stageYields = {95.0, 90.0, 85.0};
        double rty = calculationService.calculateRTY(stageYields);
        assertEquals(72.675, rty, 0.001);
    }

    @Test
    public void testCalculateCycleTime() {
        double totalProductionTime = 1000.0;
        int totalUnitsProduced = 100;
        double cycleTime = calculationService.calculateCycleTime(totalProductionTime, totalUnitsProduced);
        assertEquals(10.0, cycleTime);
    }

    @Test
    public void testCalculateSCRAP() {
        int defectiveUnits = 50;
        int totalUnitsProduced = 1000;
        double scrap = calculationService.calculateSCRAP(defectiveUnits, totalUnitsProduced);
        assertEquals(5.0, scrap);
    }

    @Test
    public void testCalculateCapacityUtilization() {
        double actualOutput = 800;
        double maxOutput = 1000;
        double capacityUtilization = calculationService.calculateCapacityUtilization(actualOutput, maxOutput);
        assertEquals(80.0, capacityUtilization);
    }

    @Test
    public void testCalculateTaktTime() {
        double availableProductionTime = 500.0;
        int customerDemand = 50;
        double taktTime = calculationService.calculateTaktTime(availableProductionTime, customerDemand);
        assertEquals(10.0, taktTime);
    }

    @Test
    public void testCalculateDowntime() {
        double totalDowntime = 100.0;
        double totalProductionTime = 1000.0;
        double downtime = calculationService.calculateDowntime(totalDowntime, totalProductionTime);
        assertEquals(10.0, downtime);
    }

    @Test
    public void testCalculateEnergyEfficiency() {
        double energyConsumed = 500.0;
        int totalUnitsProduced = 100;
        double energyEfficiency = calculationService.calculateEnergyEfficiency(energyConsumed, totalUnitsProduced);
        assertEquals(0.2, energyEfficiency);
    }

    @Test
    public void testCalculateLeadTime() {
        double timeToReceiveOrder = 10.0;
        double timeToDeliverProduct = 20.0;
        double leadTime = calculationService.calculateLeadTime(timeToReceiveOrder, timeToDeliverProduct);
        assertEquals(10.0, leadTime);
    }
}
