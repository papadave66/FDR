#!/bin/sh

SOURCES="org/rivoreo/fdr/client/LoginWindow.java
org/rivoreo/fdr/client/PPPoE.java
org/rivoreo/fdr/client/Platform.java"
set -e
cd "`dirname \"$0\"`"
[ -d ../classes ] || mkdir ../classes
exec javac -d ../classes/ $SOURCES
