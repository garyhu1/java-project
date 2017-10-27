package com.how2java.action;
 
import java.io.File;
 
public class UploadAction {
 
    File doc;
    String docFileName;
    String docContentType;
 
    public File getDoc() {
        return doc;
    }
 
    public void setDoc(File doc) {
        this.doc = doc;
    }
 
    public String getDocFileName() {
        return docFileName;
    }
 
    public void setDocFileName(String docFileName) {
        this.docFileName = docFileName;
    }
 
    public String getDocContentType() {
        return docContentType;
    }
 
    public void setDocContentType(String docContentType) {
        this.docContentType = docContentType;
    }
 
    public String upload() {
        System.out.println(doc);
        System.out.println(docFileName);
        System.out.println(docContentType);
        return "success";
    }
}