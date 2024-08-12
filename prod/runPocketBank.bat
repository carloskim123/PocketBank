@echo off
setlocal

:: Define the paths
set "JAR_URL=https://github.com/carloskim123/PocketBank/raw/main/prod/PocketBank.jar"
set "JAR_FILE=PocketBank.jar"
set "DOWNLOAD_DIR=%~dp0"
set "JAVA_EXE=%JAVA_HOME%\bin\java.exe"

:: Check if JAVA_HOME is set
if not defined JAVA_HOME (
    echo JAVA_HOME is not set. Please set JAVA_HOME to your JDK installation directory.
    pause
    exit /b 1
)

:: Check if JAR file exists
if not exist "%DOWNLOAD_DIR%%JAR_FILE%" (
    echo JAR file not found. Downloading from %JAR_URL%...
    powershell -Command "Invoke-WebRequest -Uri %JAR_URL% -OutFile '%DOWNLOAD_DIR%%JAR_FILE%'"
    if errorlevel 1 (
        echo Failed to download JAR file.
        pause
        exit /b 1
    )
)

:: Run the JAR file
echo Running the Pocket Bank application...
"%JAVA_EXE%" -jar "%DOWNLOAD_DIR%%JAR_FILE%"

pause
