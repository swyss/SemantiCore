package com.semanticore.app.semanticorebackend.controller.modules.calculations;

import com.semanticore.app.semanticorebackend.exceptions.CalculationException;
import com.semanticore.app.semanticorebackend.modules.calculations.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculations")
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    @GetMapping("/oee")
    public ResponseEntity<?> calculateOEE(
            @RequestParam double availability,
            @RequestParam double performance,
            @RequestParam double quality) {
        try {
            double result = calculationService.calculateOEE(availability, performance, quality);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/tco")
    public ResponseEntity<?> calculateTCO(
            @RequestParam double acquisitionCost,
            @RequestParam double operatingCost,
            @RequestParam double maintenanceCost) {
        try {
            double result = calculationService.calculateTCO(acquisitionCost, operatingCost, maintenanceCost);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/mtbf")
    public ResponseEntity<?> calculateMTBF(
            @RequestParam double totalOperationalTime,
            @RequestParam int numberOfFailures) {
        try {
            double result = calculationService.calculateMTBF(totalOperationalTime, numberOfFailures);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/mttr")
    public ResponseEntity<?> calculateMTTR(
            @RequestParam double totalRepairTime,
            @RequestParam int numberOfRepairs) {
        try {
            double result = calculationService.calculateMTTR(totalRepairTime, numberOfRepairs);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/yield")
    public ResponseEntity<?> calculateYield(
            @RequestParam int goodProducts,
            @RequestParam int totalProducts) {
        try {
            double result = calculationService.calculateYield(goodProducts, totalProducts);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/throughput")
    public ResponseEntity<?> calculateThroughput(
            @RequestParam int totalProducts,
            @RequestParam double processingTimeHours) {
        try {
            double result = calculationService.calculateThroughput(totalProducts, processingTimeHours);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cpk")
    public ResponseEntity<?> calculateCpk(
            @RequestParam double processMean,
            @RequestParam double targetValue,
            @RequestParam double standardDeviation,
            @RequestParam double toleranceLimit) {
        try {
            double result = calculationService.calculateCpk(processMean, targetValue, standardDeviation, toleranceLimit);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rty")
    public ResponseEntity<?> calculateRTY(
            @RequestParam double[] stageYields) {
        try {
            double result = calculationService.calculateRTY(stageYields);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cycleTime")
    public ResponseEntity<?> calculateCycleTime(
            @RequestParam double totalProductionTime,
            @RequestParam int totalUnitsProduced) {
        try {
            double result = calculationService.calculateCycleTime(totalProductionTime, totalUnitsProduced);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/scrap")
    public ResponseEntity<?> calculateSCRAP(
            @RequestParam int defectiveUnits,
            @RequestParam int totalUnitsProduced) {
        try {
            double result = calculationService.calculateSCRAP(defectiveUnits, totalUnitsProduced);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/capacityUtilization")
    public ResponseEntity<?> calculateCapacityUtilization(
            @RequestParam double actualOutput,
            @RequestParam double maxOutput) {
        try {
            double result = calculationService.calculateCapacityUtilization(actualOutput, maxOutput);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/taktTime")
    public ResponseEntity<?> calculateTaktTime(
            @RequestParam double availableProductionTime,
            @RequestParam int customerDemand) {
        try {
            double result = calculationService.calculateTaktTime(availableProductionTime, customerDemand);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/downtime")
    public ResponseEntity<?> calculateDowntime(
            @RequestParam double totalDowntime,
            @RequestParam double totalProductionTime) {
        try {
            double result = calculationService.calculateDowntime(totalDowntime, totalProductionTime);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/energyEfficiency")
    public ResponseEntity<?> calculateEnergyEfficiency(
            @RequestParam double energyConsumed,
            @RequestParam int totalUnitsProduced) {
        try {
            double result = calculationService.calculateEnergyEfficiency(energyConsumed, totalUnitsProduced);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/leadTime")
    public ResponseEntity<?> calculateLeadTime(
            @RequestParam double timeToReceiveOrder,
            @RequestParam double timeToDeliverProduct) {
        try {
            double result = calculationService.calculateLeadTime(timeToReceiveOrder, timeToDeliverProduct);
            return ResponseEntity.ok(result);
        } catch (CalculationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}