resource "aws_dynamodb_table" "my-dynamodb-test" {


  name = "my-dynamodb-test"

  read_capacity = 20

  write_capacity = 20

  range_key = "iteration"

  hash_key  = "app_id"


  attribute {
    name = "app_id"
    type = "S"
  }

  attribute {
    name = "iteration"
    type = "N"
  }


  tags = {
    Name = "test-instance"
  }


}


