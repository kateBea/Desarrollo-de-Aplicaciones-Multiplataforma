echo "deb [ arch=amd64,arm64 ] http://repo.mongodb.org/apt/ubuntu xenial/mongodb-org/3.4 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.4.list
sudo apt-get update
sudo apt-get install -y mongodb-org-tools
ongoimport --host Cluster0-shard-0/cluster0-shard-00-00-rwdsm.mongodb.net:27017,cluster0-shard-00-01-rwdsm.mongodb.net:27017,cluster0-shard-00-02-rwdsm.mongodb.net:27017 --ssl --username miguel --password miguel --authenticationDatabase admin --db prueba --collection datos --type json --file prueba.jso
