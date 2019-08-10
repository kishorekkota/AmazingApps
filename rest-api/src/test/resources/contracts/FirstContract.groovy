import org.springframework.cloud.contract.spec.Contract
import org.springframework.cloud.contract.spec.internal.HttpMethods

Contract.make {

    description 'This is my first contarct'

    request{
        url '/testpost'
        method 'POST'

        body (

            "name" : anyNonEmptyString(),
            "ssn" : anyNonEmptyString()
        )
        headers {
            contentType applicationJson()
        }

    }
    response {


        status 200

        headers {
            contentType applicationJson()
        }

        body(

                "account": anyNonEmptyString()

		)
    }
}