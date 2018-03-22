#!/bin/bash
echo "building apk"
./gradlew clean
./gradlew assembleDebug

echo "adb install"
adb install -r -d -g app/build/outputs/apk/*/app-debug.apk
