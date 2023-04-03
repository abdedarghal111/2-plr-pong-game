@echo off
title "Autoguardado en git del proyecto 'prueba'"
echo "Starting save"
echo "----------------------------------------------------------"
git add %~dp0*
git commit -m "this is autosave from 'autoguardar en git.bat'"
git push
echo "----------------------------------------------------------"
echo "Save ended"
pause
exit