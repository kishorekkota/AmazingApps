echo 'Moving REST API Jar to Amazon'


ls -ltr

scp  -i "deploy/helloworld.pem" build/libs/REST-API-1.0-SNAPSHOT.jar ec2-user@ec2-18-222-145-197.us-east-2.compute.amazonaws.com:/home/ec2-user


