#!/usr/bin/env groovy 
fileText = ./sanity.json;
fileText = fileText.replace(projectname, System.getenv("PROJECT_NAME"))
file.write(fileText)
