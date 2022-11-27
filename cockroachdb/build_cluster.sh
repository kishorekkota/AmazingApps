# Create Network

docker network create -d bridge roachnet

# Create Volumes

docker volume create roach1
docker volume create roach2
docker volume create roach3

# Create node1 / Master
docker run -d --name=roach1 --hostname=roach1 --net=roachnet -p 26257:26257 -p 8080:8080  -v "roach1:/cockroach/cockroach-data"  cockroachdb/cockroach:v22.1.11 start --insecure --join=roach1,roach2,roach3

#Create Node2
docker run -d --name=roach2 --hostname=roach2 --net=roachnet -v "roach2:/cockroach/cockroach-data" cockroachdb/cockroach:v22.1.11 start --insecure --join=roach1,roach2,roach3

#Create Node3
docker run -d --name=roach3 --hostname=roach3 --net=roachnet -v "roach3:/cockroach/cockroach-data" cockroachdb/cockroach:v22.1.11 start --insecure --join=roach1,roach2,roach3

docker exec -it roach1 ./cockroach init --insecure

#docker exec -it roach1 ./cockroach sql --insecure
#docker exec -it roach2 ./cockroach sql --insecure
#docker exec -it roach1 ./cockroach workload init movr 'postgresql://root@roach1:26257?sslmode=disable'


