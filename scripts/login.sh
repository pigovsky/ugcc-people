#!/bin/bash -x

curl -H "Accept: application/json" \
  -H "Content-Type: application/json" \
  -d '{"otp": "'$1'"}' localhost:8080/api/v1/login
