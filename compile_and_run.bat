@echo off
echo ===================================================
echo     Compilando o projeto Sistema de Alunos
echo ===================================================
if not exist bin mkdir bin
javac -encoding UTF-8 -cp "mysql-connector-java-5.1.15-bin.jar" -d bin src/br/com/menu/model/*.java src/br/com/menu/util/*.java src/br/com/menu/dao/*.java src/br/com/menu/view/*.java
if %errorlevel% neq 0 (
    echo.
    echo [ERRO] Falha na compilacao! Verifique os erros acima.
    pause
    exit /b %errorlevel%
)
echo.
echo [SUCESSO] Compilacao concluida!
echo Iniciando o aplicativo...
echo ===================================================
java -cp "bin;mysql-connector-java-5.1.15-bin.jar" br.com.menu.view.TelaPrincipal
