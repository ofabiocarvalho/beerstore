resource "aws_security_group" "allow_ssh" {
    vpc_id = "${aws_vpc.main.id}"
    name = "ofabiocarvalho_allow_ssh"

    ingress {
        from_port = 22
        to_port = 22
        protocol = "tcp"
        cidr_blocks = [
            "144.22.111.1/32",
            "187.44.97.73/32",
            "177.39.96.180/32"
        ]
    }
}

resource "aws_security_group" "database" {
    vpc_id = "${aws_vpc.main.id}"
    name = "ofabiocarvalho_database"

    ingress {
        from_port = 5432
        to_port = 5432
        protocol = "tcp"
        self = true
    }  
}
