package com.example.awsdynamodb;

import com.example.aws.dynamo.DynamoDataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AwsDynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsDynamodbApplication.class, args);
	}


}

@RestController
class MyRestController
{

	@GetMapping("/createtable")
	public void createtable()
	{

        DynamoDataBase dynamoDB = new DynamoDataBase();

        dynamoDB.createTable();

	}


    @GetMapping("/puttable")
    public void puttable()
    {

        DynamoDataBase dynamoDB = new DynamoDataBase();

        dynamoDB.putItem();

    }

    @GetMapping("/gettable")
    public void gettable()
    {

        DynamoDataBase dynamoDB = new DynamoDataBase();

        dynamoDB.getItem();

    }
}
