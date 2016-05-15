#!/bin/bash
mkdir -p search-export
../java.sh pascal.Pascal bubble.pascal -search if while > search-export/bubble.txt
../java.sh pascal.Pascal BubbleSort.pascal -search if while for > search-export/bubbleSort.txt
../java.sh pascal.Pascal helloworld.pascal -search if while > search-export/helloworld.txt
../java.sh pascal.Pascal sample1.pascal -search if > search-export/sample1.txt
../java.sh pascal.Pascal sample2.pascal -search if > search-export/sample2.txt
../java.sh pascal.Pascal savings.pascal -search if for > search-export/savings.txt
