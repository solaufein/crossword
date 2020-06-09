### crossword


##### tools:

    - gradle
    - java 11
    - spring boot
    - postgres
    - h2 (tests)
    - elasticsearch

# 
##### build app:

    gradle clean build
 
##### run app:

    gradle bootRun

#    
##### run elasticsearch:
    
    docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.7.1

###### elasticsearch health check

    curl -X GET "localhost:9200/_cat/nodes?v&pretty"

###### set vm.max_map_count to at least 262144
    docker-machine ssh
    sudo sysctl -w vm.max_map_count=262144
    
