package com.example.dailyhealth;

import java.io.Serializable;
import java.lang.Math;

public class AsthmaMeasurement implements Serializable {
    //Private
    //Gathered from measurement pages
    private int measuredPeakFlow;
    private int predictedPeakFlow;
    private int sentenceFormation;
    private int respiratoryRate;
    private int respiratoryEffort;
    private int heartRate;
    private int exhaustion;
    //Gathered from user details
    private int age;
    private int height;
    private boolean sex;
    //Calculations
    private boolean[] emergency;

    //Public
    //Constructor
    AsthmaMeasurement(){
        measuredPeakFlow = 0;
        predictedPeakFlow = 0;
        sentenceFormation = 0;
        respiratoryRate = 0;
        respiratoryEffort = 0;
        heartRate = 0;
        exhaustion = 0;
        emergency = new boolean[6];
    }

    //Set
    void setMeasuredPeakFlow(int reading){measuredPeakFlow=reading;}
    void setPredictedPeakFlow(int reading){predictedPeakFlow=reading;}
    void setSentenceFormation(int reading){sentenceFormation=reading;}
    void setRespiratoryRate(int reading){respiratoryRate=reading;}
    void setRespiratoryEffort(int reading){respiratoryEffort=reading;}
    void setHeartRate(int reading){heartRate=reading;}
    void setExhaustion(int reading){exhaustion=reading;}

    //Get
    int getMeasuredPeakFlow(){return measuredPeakFlow;}
    int getPredictedPeakFlow(){return predictedPeakFlow;}
    int getSentenceFormation(){return sentenceFormation;}
    int getRespiratoryRate(){return respiratoryRate;}
    int getRespiratoryEffort(){return respiratoryEffort;}
    int getHeartRate(){return heartRate;}
    int getExhaustion(){return exhaustion;}

    //Calculation
    int calculateFlowPercentage(double a, double b){
        return (int)(a/b*100);
    }

    void calculatePredictedPeakFlow(boolean gender, int age, int height){

        if(gender){
            //Male
            predictedPeakFlow = (int)Math.exp((0.544*Math.log(age))-(.0151*age)-(74.7/height)+5.48);
        } else {
            //Female
            predictedPeakFlow = (int)Math.exp((0.376*Math.log(age))-(.012*age)-(58.8/height)+5.63);
        }

    }

    int calculateSeverityTotal(){
        int severityTotal = 0;
        for(int i = 0; i < emergency.length; i++){emergency[i]=false;}

        //Flow% -- [0]
        if(calculateFlowPercentage(measuredPeakFlow,predictedPeakFlow) > 70){
            severityTotal+=0;
        } else if(calculateFlowPercentage(measuredPeakFlow,predictedPeakFlow) > 50 && calculateFlowPercentage(measuredPeakFlow,predictedPeakFlow) <= 70){
            severityTotal+=1;
        } else if(calculateFlowPercentage(measuredPeakFlow,predictedPeakFlow) > 33 && calculateFlowPercentage(measuredPeakFlow,predictedPeakFlow) <= 50){
            severityTotal+=2;
        } else if(calculateFlowPercentage(measuredPeakFlow,predictedPeakFlow) <=33) {
            severityTotal+=3;
            emergency[0] = true;
        }

        //Sentences
        switch (sentenceFormation){
            case 0:
                severityTotal+=0;
                break;
            case 1:
                severityTotal+=1;
                break;
            case 2:
                severityTotal+=2;
                break;
            case 3:
                severityTotal+=3;
                emergency[1] = true;
                break;
        }

        //Respiratory Rate
        if(respiratoryRate < 18){
            severityTotal+=0;
        } else if(respiratoryRate > 18 && respiratoryRate < 24){
            severityTotal+=1;
        } else {
            severityTotal+=3;
            emergency[2] = true;
        }

        //Respiratory Effort
        switch (respiratoryEffort){
            case 0:
                severityTotal+=0;
                break;
            case 1:
                severityTotal+=1;
                break;
            case 2:
                severityTotal+=2;
                break;
            case 3:
                severityTotal+=3;
                emergency[3] = true;
                break;
        }

        //Heart Rate
        if(heartRate <= 99 && heartRate > 50){
            severityTotal+=0;
        } else if(heartRate <= 130 && heartRate > 99){
            severityTotal+=1;
        } else if(heartRate > 130){
            severityTotal+=3;
            emergency[4] = true;
        }

        //Exhaustion
        switch (exhaustion){
            case 0:
                severityTotal+=0;
                break;
            case 1:
                severityTotal+=1;
                break;
            case 2:
                severityTotal+=2;
                break;
            case 3:
                severityTotal+=3;
                emergency[5] = true;
                break;
        }

        return severityTotal;
    }

    int calculateSeverity(int severityTotal){

        //Emergency -- if 2+ emergency = true severity = emergency
        int temp=0;
        for(int i = 0; i < emergency.length; i++){
            if (emergency[i]){temp+=1;}
        }
        if (temp >= 2){return 3;}

        //Regular Severity Check
        if(severityTotal <= 2){
            //Severity = Mild
            return  0;
        } else if (severityTotal <= 6 && severityTotal > 2){
            //Severity = Moderate
            return  1;
        } else if (severityTotal <= 14 && severityTotal > 6){
            //Severity = Severe
            return  2;
        } else {
            //Severity = Emergency
            return  3;
        }
    }

}
