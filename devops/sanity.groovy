#!/usr/bin/env groovy
def test = System.getenv("PROJECT_NAME")
def sanity = new AntBuilder()   
sanity.replace(file: "./sanity.json", token: "project_name", value: "test")
