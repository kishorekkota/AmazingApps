package com.example.aws.dynamo;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;

@DynamoDBDocument
@Data
public class Applicant {

    @DynamoDBAttribute
    public String name = "Kishore Kota";

    @DynamoDBAttribute
    public String ssn = "123456789";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
