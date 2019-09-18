resource "aws_instance" "my-test-instance" {

  #ami = "${data.aws_ami.ubuntu.id}"

  ami = "ami-04169656fea786776"

  instance_type = "t2.micro"

  security_groups = ["allow-all-sg"]

  key_name = "kishore-ec2-bhargavi-account"

  user_data = <<-EOF
  #! /bin/bash -v
  sudo apt-get update
  sudo apt-get install -y apache2
  sudo systemctl start apache2
  sudo systemctl enable apache2
  echo "<h1>Deployed via Terraform</h1>" | sudo tee /var/www/html/index.html
  EOF

  tags = {
    Name = "test-instance"
  }




  provisioner "local-exec" {
    command = "echo ${aws_instance.my-test-instance.public_ip}"

  }




  #provisioner "remote-exec" {
  #  inline = [
  #    "sudo apt-get update",
  #    "sudo apt-get -y install apache"
  #  ]
  #}
}


