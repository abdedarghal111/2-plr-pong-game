@echo off
echo "test"
echo %~dp0
git add %~dp0*
git commit -m "this is autosave from 'autoguardar en git.bat'"
git push
pause