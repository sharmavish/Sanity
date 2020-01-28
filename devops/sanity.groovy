#!/usr/bin/env groovy
def sanity = new AntBuilder()   
sanity.replace(file: "./sanity.json", token: "project_name", value: "System.getenv("PROJECT_NAME")")
