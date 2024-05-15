#!/bin/bash

echo OFF

echo "..start.database.server.."
# ./lib/hsqldb/bin/runServer.sh
echo "-success-"

echo "..start.game.."
java -cp .:./lib/core/library/core.jar:./lib/hsqldb/lib/hsqldb.jar:./bin main
echo "-success-"
