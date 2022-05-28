echo OFF

echo ..start.database.server..
start /min .\lib\hsqldb\bin\runServer.bat
echo -success-

echo ..start.game..
java -cp .;.\lib\core\library\core.jar.;.\lib\hsqldb\lib\hsqldb.jar.;.\bin main
echo -success-