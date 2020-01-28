#!/usr/bin/env groovy
def project_name = "projectname"
def project = "System.getenv("PROJECT_NAME)"
def project_id = "projectid"
def id = "$PROJECT_ID"
def dataset_name = "datasetname"
def dateset = "$DATEAET_NAME"


fileText = ./sanity.json;
fileText = fileText.replaceAll(project_name, project)
file.write(fileText)
