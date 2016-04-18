mkdir xml-export
for %%f in (*.pascal) do call ../java.bat pascal.Pascal %%f -xml > xml-export/%%~nf.xml
