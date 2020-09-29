# crossword

#### tools:
    - gradle
    - java 11
    - spring boot
    - postgres
    - h2 (tests)
    - docker 
    - elasticsearch

#### build app:
    gradle clean build
 
#### run app:
    gradle bootRun
  
#### start elasticsearch:
    ./es-start.sh
 
#### stop elasticsearch:
    ./es-start.sh

#### elasticsearch health check:
    curl -X GET "localhost:9200/_cat/nodes?v&pretty"

#### set vm.max_map_count to at least 262144
    docker-machine ssh
    sudo sysctl -w vm.max_map_count=262144
    
