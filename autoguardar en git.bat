@echo off
title Autoguardado en git del proyecto "prueba"
color 0B
echo Starting save
echo ----------------------------------------------------------%n%n

git add %~dp0*
git commit -m "This is autosave from 'autoguardar en git.bat'."
git push
echo %n%n----------------------------------------------------------
echo Save ended
pause
exit