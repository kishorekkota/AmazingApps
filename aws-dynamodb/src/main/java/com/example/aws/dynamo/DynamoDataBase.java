package com.example.aws.dynamo;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.services.s3.model.Region;

import java.util.HashMap;

public class DynamoDataBase {


    public void createTable() {


        BasicAWSCredentials awsCreds = getBasicAuth();

        AWSCredentialsProvider creds = new AWSCredentialsProvider() {
            @Override
            public AWSCredentials getCredentials() {
                return awsCreds;
            }

            @Override
            public void refresh() {

            }
        };

        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(creds).build();

        CreateTableRequest request = new CreateTableRequest().
                withAttributeDefinitions(new AttributeDefinition("ApplicationId", ScalarAttributeType.S)).
                withAttributeDefinitions(new AttributeDefinition("PassNumber", ScalarAttributeType.N)).
                withProvisionedThroughput(
                        new ProvisionedThroughput(new Long(10), new Long(10))).
                withKeySchema(new KeySchemaElement("ApplicationId", KeyType.HASH)).
                withKeySchema(new KeySchemaElement("PassNumber", KeyType.RANGE)).withTableName("my_blaze_input_output");


        try {
            ddb.createTable(request);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


//    public void putItem()
//    {
//
//        //ListTablesRequest request = new ListTablesRequest().withLimit(10).withExclusiveStartTableName("my_blaze_input_output").;
//
//
//
//        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAUWKXC562MCDAUIJF","B6VxypsoGF/Qy8efdeoUms1jbuz+C87NupbBviF5");
//
//        AWSCredentialsProvider creds = new AWSCredentialsProvider() {
//            @Override
//            public AWSCredentials getCredentials() {
//                return awsCreds;
//            }
//
//            @Override
//            public void refresh() {
//
//            }
//        };
//
//        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(creds).build();
//
//        //DynamoDBQueryExpression
//        HashMap<String,AttributeValue> item_values = new HashMap<String,AttributeValue>();
//
//
//        item_values.put("ApplicationId",new AttributeValue("APPLICATION_ID"));
//
//        item_values.put("PassNumber",new AttributeValue().withN("1"));
//
//        //item_values.put("ApplicantData",);
//
//
//        ddb.putItem("my_blaze_input_output",item_values);
//
//
//
//    }


    public void putItem() {

        //ListTablesRequest request = new ListTablesRequest().withLimit(10).withExclusiveStartTableName("my_blaze_input_output").;


        BasicAWSCredentials awsCreds = getBasicAuth();

        AWSCredentialsProvider creds = new AWSCredentialsProvider() {
            @Override
            public AWSCredentials getCredentials() {
                return awsCreds;
            }

            @Override
            public void refresh() {

            }
        };

        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(creds).build();

        DynamoDBMapper mapper = new DynamoDBMapper(ddb);


        BlazeOM om = new BlazeOM();


//        ddb.createTable(mapper.generateCreateTableRequest(BlazeOM.class).withProvisionedThroughput(
//                new ProvisionedThroughput(new Long(10), new Long(10))));

        mapper.save(om);


    }


    public void getItem() {

        BasicAWSCredentials awsCreds = getBasicAuth();

        AWSCredentialsProvider creds = new AWSCredentialsProvider() {
            @Override
            public AWSCredentials getCredentials() {
                return awsCreds;
            }

            @Override
            public void refresh() {

            }
        };

        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(creds).build();

        DynamoDBMapper mapper = new DynamoDBMapper(ddb);


        BlazeOM om = new BlazeOM();

        PaginatedScanList<BlazeOM> results = mapper.scan(BlazeOM.class, new DynamoDBScanExpression().withLimit(100));


        System.out.println(results);

    }


    private BasicAWSCredentials getBasicAuth()
    {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("XX", "xx");
        return awsCreds;

    }
}
