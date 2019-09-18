package com.example.aws.dynamo;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;

@DynamoDBDocument
@Data
public class FraudInfo {

    @DynamoDBAttribute
    public int modelScore = 400;

    public int getModelScore() {
        return modelScore;
    }

    public void setModelScore(int modelScore) {
        this.modelScore = modelScore;
    }
}
