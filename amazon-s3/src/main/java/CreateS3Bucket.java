import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.*;

/*
        Access Key ID:
        aws_access_key_id = AKIAJCQQZKVUARAOWPVQ
        Secret Access Key:
        aws_secret_access_key = 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
*/

public class CreateS3Bucket {

    public AmazonS3 createS3Client()
    {
        AmazonS3 s3 =  AmazonS3Client.builder().build();
        //s3.setRegion(Region.getRegion(Regions.US_EAST_2));
        return s3;
    }

    public Bucket createS3Bucker(AmazonS3 s3, String bucketName)
    {
        return s3.createBucket(bucketName);



    }

    public void createObject(AmazonS3 s3,Bucket bucket) throws Exception
    {

        s3.putObject(new PutObjectRequest(bucket.getName(),"myfirsts3key"+Math.random(), createSampleFile()));

    }



    public static void main(String[] args)
    {
        CreateS3Bucket buket = new CreateS3Bucket();

        AmazonS3 s3 =buket.createS3Client();
        Bucket bk = buket.createS3Bucker(s3,"bucketname"+Math.random());

        try {
            buket.createObject(s3,bk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Creates a temporary file with text data to demonstrate uploading a file
     * to Amazon S3
     *
     * @return A newly created temporary file with text data.
     *
     * @throws IOException
     */
    private static File createSampleFile() throws IOException {
        File file = File.createTempFile("aws-java-sdk-", ".txt");
        file.deleteOnExit();

        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.write("01234567890112345678901234\n");
        writer.write("!@#$%^&*()-=[]{};':',.<>/?\n");
        writer.write("01234567890112345678901234\n");
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.close();

        return file;
    }
}
