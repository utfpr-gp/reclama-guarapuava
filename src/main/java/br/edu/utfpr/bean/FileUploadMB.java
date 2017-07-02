/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "fileUploadMB")
@ViewScoped
public class FileUploadMB {

    public FileUploadMB() {
    }

    private Part uploadedFile;
    // private UploadedFile uploadedFile; // +getter+setter

    public void doUpload(FileUploadEvent fileUploadEvent) {

        UploadedFile uploadedFile = fileUploadEvent.getFile();

        String fileNameUploaded = uploadedFile.getFileName();
        String type = uploadedFile.getContentType();
        System.out.println("File type: " + type);

        long fileSizeUploaded = uploadedFile.getSize();
        String infoAboutFile = "<br/> Arquivo recebido: <b>" + fileNameUploaded + "</b><br/>"
                + "Tamanho do Arquivo: <b>" + fileSizeUploaded + "</b>";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage("Sucesso", infoAboutFile));

    }

}
