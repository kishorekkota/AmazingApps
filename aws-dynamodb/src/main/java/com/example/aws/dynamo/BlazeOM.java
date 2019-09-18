package com.example.aws.dynamo;


import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;
import org.springframework.context.ApplicationContext;


@DynamoDBTable(tableName = "my_blaze_input_output")
@Data
public class BlazeOM {

    @DynamoDBHashKey(attributeName = "ApplicationId")
    public String applicationId = "appid123";

    @DynamoDBRangeKey(attributeName = "PassNumber")
    public Integer passNumber = 10;

    @DynamoDBAttribute
    public Applicant applicant;

    @DynamoDBAttribute
    public FraudInfo fraud;

    @DynamoDBAttribute
    public ThreatmatrixInfo tmx;

    public String getTestAttribute() {
        return testAttribute;
    }

    public void setTestAttribute(String testAttribute) {
        this.testAttribute = testAttribute;
    }

    public Integer getTestInteger() {
        return testInteger;
    }

    public void setTestInteger(Integer testInteger) {
        this.testInteger = testInteger;
    }

    @DynamoDBAttribute
    public String testAttribute = "test is the value";

    @DynamoDBAttribute
    public Integer testInteger = 100;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(Integer passNumber) {
        this.passNumber = passNumber;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public FraudInfo getFraud() {
        return fraud;
    }

    public void setFraud(FraudInfo fraud) {
        this.fraud = fraud;
    }

    public ThreatmatrixInfo getTmx() {
        return tmx;
    }

    public void setTmx(ThreatmatrixInfo tmx) {
        this.tmx = tmx;
    }
}

