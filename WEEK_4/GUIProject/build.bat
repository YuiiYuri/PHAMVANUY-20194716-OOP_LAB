@echo off
mkdir out
javac -encoding UTF-8 -d out ^
src/hust/soict/dsai/aims/*.java ^
src/hust/soict/dsai/aims/cart/*.java ^
src/hust/soict/dsai/aims/media/*.java ^
src/hust/soict/dsai/aims/store/*.java ^
src/hust/soict/dsai/aims/screen/manager/*.java
pause
