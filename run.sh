echo "\033[1;31m----< iniciando o docker-compose >------\033[0m"
sudo docker-compose -f ./docker/docker-compose.yaml up --build -d
echo "\033[1;32m----< Concluido >------\033[0m"

