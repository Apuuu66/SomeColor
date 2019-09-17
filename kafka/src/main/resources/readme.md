kafka-topics.sh --create --zookeeper 192.168.44.138:2181 --replication-factor 3 --partitions 4 --topic test-topic
kafka-topics.sh --describe --zookeeper 192.168.44.138:2181 --topic test-topic
kafka-console-consumer.sh --bootstrap-server 192.168.44.138:9092 --topic test-topic --from-beginning
./kafka-topics.sh --zookeeper 192.168.44.138:2181 --list