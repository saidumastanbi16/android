@echo off
echo Compiling Java files...
mkdir build\classes 2>nul

javac -d build\classes -cp "app\src\main\java" ^
    app\src\main\java\com\ventureplus\crm\*.java

if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    echo Java classes compiled to build\classes\
) else (
    echo Compilation failed!
)
pause
