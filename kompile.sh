#!/bin/bash

echo OFF
echo "..kompilieren.."
javac -cp .:./lib/core/library/core.jar:./lib/hsqldb/lib/hsqldb.jar -d ./bin source/*.java
echo "..done.."
read -p "Press any key to continue..."
