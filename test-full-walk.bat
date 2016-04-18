mkdir txt-full-export
for %%f in (*.pascal) do call ../java.bat pascal.Pascal %%f -path 1 > txt-full-export/%%~nf.txt
