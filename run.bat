@echo off
echo Iniciando o Sistema de Alunos...
java -cp "bin;mysql-connector-java-5.1.15-bin.jar" br.com.menu.view.TelaPrincipal
if %errorlevel% neq 0 (
    echo.
    echo [ERRO] Ocorreu um erro ao rodar a aplicacao. 
    echo Certifique-se de compilar primeiro usando o compile_and_run.bat
    pause
)
