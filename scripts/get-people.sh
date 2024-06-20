#!/bin/bash -x

curl -H 'session-key: '$1 http://localhost:8080/api/v1/countries/$2/cities/$3/churches/$4/people
