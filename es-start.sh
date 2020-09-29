#!/bin/bash

docker run -itd -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" --name my-es docker.elastic.co/elasticsearch/elasticsearch:7.7.1
