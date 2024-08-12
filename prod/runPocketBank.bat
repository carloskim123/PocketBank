@echo off
setlocal

:: Define variables
set "JAR_URL=https://github.com/carloskim123/PocketBank/raw/main/prod/PocketBank.jar"
set "JAR_FILE=PocketBank.jar"

:: Download the JAR file
echo Downloading the JAR file from %JAR_URL%...
curl -L -o "%JAR_FILE%" "%JAR_URL%"

:: Check if download was successful
if not exist "%JAR_FILE%" (
    echo Failed to download the JAR file.
    exit /b 1
)

:: Run the JAR file using the default java executable
echo Running the Pocket Bank application...
java -jar "%JAR_FILE%"

pause
