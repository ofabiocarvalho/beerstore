resource "aws_key_pair" "keypair" {
    public_key = "${file("key/beerstore_key.pub")}"  
}

resource "aws_instance" "instances" {
    count = 3
    ami = "ami-0b69ea66ff7391e80"
    instance_type = "t2.micro"
    
    subnet_id = "${element(aws_subnet.public_subnet.*.id, count.index)}"

    key_name = "${aws_key_pair.keypair.key_name}"

    vpc_security_group_ids = ["${aws_security_group.allow_ssh.id}"]

    tags = {
        Name = "ofabiocarvalho_instance_${count.index}"        
    }
}

output "public_ips" {
  value = "${join(",", aws_instance.instances.*.public_ip)}"
}
