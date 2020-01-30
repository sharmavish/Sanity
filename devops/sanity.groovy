#!/usr/bin/env groovy 
 def subdir = new File('/home/runner/.config/sanity/')
      subdir.mkdir()
def file = new File("devops/config.json")
def newFile = new File("/home/runner/.config/sanity/")
Files.copy(file.toPath(), newFile.toPath())

