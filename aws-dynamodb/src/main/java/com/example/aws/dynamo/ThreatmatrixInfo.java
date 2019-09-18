package com.example.aws.dynamo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;

@DynamoDBDocument
@Data
public class ThreatmatrixInfo {


    @DynamoDBAttribute
    public String trueIp = "10.10.11.11";

    public String getTrueIp() {
        return trueIp;
    }

    public void setTrueIp(String trueIp) {
        this.trueIp = trueIp;
    }
}
