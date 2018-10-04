#!/bin/sh

SOURCES="org/rivoreo/fdr/client/LoginWindow.java
org/rivoreo/fdr/client/PPPoE.java
org/rivoreo/fdr/client/Platform.java"
[ -d ../classes ] || mkdir ../classes
exec javac -d ../classes/ $SOURCES
