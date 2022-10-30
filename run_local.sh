# shellcheck disable=SC2164
cd admin-module
./gradlew bootjar
# shellcheck disable=SC2103
cd ..
docker build -f docker/Dockerfile_local -t emergency-alert-system .

#nohup docker-compose up 1>/dev/null 2>&1 &
docker-compose up
