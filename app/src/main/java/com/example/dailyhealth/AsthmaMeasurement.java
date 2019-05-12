package com.example.dailyhealth;

import java.lang.Math;

public class AsthmaMeasurement {
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
    private int calculateFlowPercentage(){
        float temp;
        temp = (float)measuredPeakFlow/(float)predictedPeakFlow;
        return (int)temp*100;
    }

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
    }

    //Set
    void setMeasuredPeakFlow(int reading){measuredPeakFlow=reading;}
    void setPredictedPeakFlow(int reading){predictedPeakFlow=reading;}
    void setSentenceFormation(int reading){sentenceFormation=reading;}
    void setRespiratoryRate(int reading){respiratoryRate=reading;}
    void setRespiratoryEffort(int reading){respiratoryEffort=reading;}
    void setHeartRate(int reading){heartRate=reading;}
    void setExhaustion(int reading){exhaustion=reading;}

    //Calculation
    int calculateSeverity(){
        int severityTotal = 0;
        boolean[] emergency = new boolean[6];
        for(int i = 0; i < emergency.length; i++){emergency[i]=false;}

        //Predicted Peak Flow
        if(predictedPeakFlow == 0){
            if(sex){
                //Male
                predictedPeakFlow = (int)Math.exp((0.544*Math.log(age))-(.0151*age)-(74.7/height)+5.48);
            } else {
                //Female
                predictedPeakFlow = (int)Math.exp((0.376*Math.log(age))-(.012*age)-(58.8/height)+5.63);
            }
        }

        //Flow% -- [0]
        if(calculateFlowPercentage() > 70){
            severityTotal+=0;
        } else if(calculateFlowPercentage() > 50 && calculateFlowPercentage() <= 70){
            severityTotal+=1;
        } else if(calculateFlowPercentage() > 33 && calculateFlowPercentage() <= 50){
            severityTotal+=2;
        } else {
            severityTotal+=3;
            emergency[0] = true;
        }

        //Sentences
        switch (sentenceFormation){
            case 0:
                severityTotal+=0;
            case 1:
                severityTotal+=1;
            case 2:
                severityTotal+=2;
            case 3:
                severityTotal+=3;
                emergency[1] = true;
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
            case 1:
                severityTotal+=1;
            case 2:
                severityTotal+=2;
            case 3:
                severityTotal+=3;
                emergency[3] = true;
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
            case 1:
                severityTotal+=1;
            case 2:
                severityTotal+=2;
            case 3:
                severityTotal+=3;
                emergency[5] = true;
        }

        //Calculate
        int severity = 0;
        if(severityTotal <= 2){
            //Severity = Mild
            severity = 0;
        } else if (severityTotal <= 4 && severityTotal > 2){
            //Severity = Moderate
            severity = 1;
        } else if (severityTotal <= 8 && severityTotal > 4){
            //Severity = Severe
            severity = 2;
        } else {
            //Severity = Emergency
            severity = 3;
        }
        //Emergency -- if 2+ emergency = true severity = emergency
        int temp=0;
        for(int i = 0; i < emergency.length; i++){
            if (emergency[i]){temp+=1;}
        }
        if (temp >= 2){severity=3;}

        return severity;
    }


}
