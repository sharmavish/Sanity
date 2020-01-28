#!/usr/bin/env groovy
def project_name = "projectname"
def project = System.getenv("PROJECT_NAME")
fileText = ./sanity.json;
fileText = fileText.replaceAll(project_name, project)
file.write(fileText)
