#!/usr/bin/bash
# This script cleanup all the log which is older than a month

cd /home/tomcatusr
pwd
echo "finding files to remove"
find /home/tomcatusr/apache-tomcat-8.5.24/logs -type f -mtime +30  -exec rm -rf -- {} \;
echo "Removing files"

exit




