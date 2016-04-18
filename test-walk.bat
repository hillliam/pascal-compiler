mkdir txt-export
for %%f in (*.pascal) do call ../java.bat pascal.Pascal %%f  -path > txt-export/%%~nf.txt
