#!/bin/bash

cd ./lib/hsqldb/data
java -cp ../lib/hsqldb.jar org.hsqldb.server.Server
