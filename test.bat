mkdir js-export
for %%f in (*.pascal) do call ../java.bat pascal.Pascal %%f > js-export/%%~nf.js
