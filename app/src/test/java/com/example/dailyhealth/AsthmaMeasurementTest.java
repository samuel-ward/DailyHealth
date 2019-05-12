package com.example.dailyhealth;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AsthmaMeasurementTest {
    //Assume Set/Get methods work

    private AsthmaMeasurement test;

    @Before
    public void set_up_test_environment(){
        test = new AsthmaMeasurement();
    }

    @Test
    public void asthma_measurement_flow_percentage(){
        int expected = 60;
        int actual = test.calculateFlowPercentage(60,100);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void asthma_measurement_calculated_peak_flow_male(){
        int expected = 654;
        test.calculatePredictedPeakFlow(true, 30, 190);
        int actual = test.getPredictedPeakFlow();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void asthma_measurement_calculated_peak_flow_female(){
        int expected = 506;
        test.calculatePredictedPeakFlow(false, 30, 183);
        int actual = test.getPredictedPeakFlow();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void asthma_measurement_severity_mild_all(){
        //All Mild
        int expected = 0;
        test.setRespiratoryEffort(0);
        test.setRespiratoryRate(17);
        test.setSentenceFormation(0);
        test.setExhaustion(0);
        test.setHeartRate(80);
        test.setPredictedPeakFlow(660);
        test.setMeasuredPeakFlow(600);
        int actual = test.calculateSeverity();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void asthma_measurement_severity_moderate_all(){
        //All Moderate
        int expected = 1;
        test.setRespiratoryEffort(1);
        test.setRespiratoryRate(22);
        test.setSentenceFormation(1);
        test.setExhaustion(1);
        test.setHeartRate(110);
        test.setPredictedPeakFlow(660);
        test.setMeasuredPeakFlow(500);
        int actual = test.calculateSeverity();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void asthma_measurement_severity_severe_all(){
        //All Severe
        int expected = 2;
        test.setRespiratoryEffort(2);
        test.setRespiratoryRate(22);
        test.setSentenceFormation(2);
        test.setExhaustion(2);
        test.setHeartRate(80);
        test.setPredictedPeakFlow(660);
        test.setMeasuredPeakFlow(500);
        int actual = test.calculateSeverity();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void asthma_measurement_severity_emergency_all(){
        //All Emergency
        int expected = 3;
        test.setRespiratoryEffort(3);
        test.setRespiratoryRate(24);
        test.setSentenceFormation(3);
        test.setExhaustion(3);
        test.setHeartRate(150);
        test.setPredictedPeakFlow(660);
        test.setMeasuredPeakFlow(120);
        int actual = test.calculateSeverity();
        Assert.assertEquals(expected, actual);
    }

}
