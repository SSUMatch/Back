#!/bin/bash

IS_GREEN_EXIST=$(docker ps | grep green)
DEFAULT_CONF=" /etc/nginx/nginx.conf"

# green up
if [ -z $IS_GREEN_EXIST ];then
  echo ">>> green image pull"
  docker-compose pull green
  echo ">>> green container up"
  docker-compose up -d green
  while [ 1 = 1 ]; do
    echo ">>> health check"
    sleep 3
    REQUEST=$(curl http://127.0.0.1:8082)
    if [ -n "$REQUEST" ]; then
      echo ">>> health check success !"
      break;
    fi
  done;
  sleep 3
  echo ">>> nginx restart"
  sudo cp /etc/nginx/nginx.green.conf /etc/nginx/nginx.conf
  sudo nginx -s reload
  echo ">>> blue container down"
  docker-compose stop blue

# blue up
else
  echo ">>> blue image pull"
  docker-compose pull blue
  echo ">>> blue container up"
  docker-compose up -d blue
  while [ 1 = 1 ]; do
    echo ">>> health check"
    sleep 3
    REQUEST=$(curl http://127.0.0.1:8081)
    if [ -n "$REQUEST" ]; then
      echo ">>> health check success !"
      break;
    fi
  done;
  sleep 3
  echo ">>> nginx restart"
  sudo cp /etc/nginx/nginx.blue.conf /etc/nginx/nginx.conf
  sudo nginx -s reload
  echo ">>> green container down"
  docker-compose stop green
fi
