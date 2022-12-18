package com.example.creadible.Model.service.impl;

import com.example.creadible.Model.domain.entity.Model;
import com.example.creadible.Model.domain.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl {
    private final ModelRepository modelRepository;
    public MultipartFile writeCSV(Long id) {
        String filepath = "/Users/mincho/Desktop/fourth/creadible/src/main/resources/csv/data.csv";
        File file = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        String new_line = System.lineSeparator();


        try {
            file = new File(filepath);
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            Model model = modelRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 ID를 가진 model이 없습니다!"+id));
            String data = model.getId().toString()+","+Integer.toString(model.getGender())+","+Integer.toString(model.getAge())+","+Integer.toString(model.getMarried())+","+Integer.toString(model.getDependents())+","+Integer.toString(model.getEducation())+","+Integer.toString(model.getSelfEmployed())+","+
                    Integer.toString(model.getBusinessType())+","+Integer.toString(model.getApplicantIncome())+","+Integer.toString(model.getApplicantWorkPeriod())+","+Float.toString(model.getCoapplicantIncome())+","+Float.toString(model.getCreditHistory())+","+Integer.toString(model.getCreditAmount())+","+
                    Integer.toString(model.getPropertyArea())+","+Integer.toString(model.getPropertyType())+","+Integer.toString(model.getCreditRate())+","+Integer.toString(model.getLoanAmount())+","+Integer.toString(model.getLoanTerm());
            //헤더 생성
            bw.write("id,gender,age,married,dependents,education,selfEmployed,businessType,applicantIncome,applicantWorkPeriod,coapplicantIncome,creditHistory,creditAmount,propertyArea,propertyType,creditRate,loanAmount,loanTerm");
            bw.write(new_line);
            bw.write(data);

            bw.flush();
            bw.close();

            FileItem fileItem = new DiskFileItem("file", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());
            InputStream input = new FileInputStream(file);
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(input, os);

            MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
            return multipartFile;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try{
                    fw.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}



