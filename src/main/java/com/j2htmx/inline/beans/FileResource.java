package com.j2htmx.inline.beans;

public class FileResource {
    private String fileLocation;

    public FileResource(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }
}
