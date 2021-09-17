echo "\033[1;31m----< parando o docker-compose >------\033[0m"
sudo docker-compose -f ./docker/docker-compose.yaml down --rmi all
echo "\033[1;32m----< concluído >------\033[0m"