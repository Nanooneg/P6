package com.nanoo.business.util;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author nanoo
 * @create 14/10/2019 - 12:22
 */
public class UploadUtil {
    
    private static final Logger log = LoggerFactory.getLogger(UploadUtil.class);
    
    
    private static final String ABS_PATH = "/resources/";
    private static final String REAL_PATH = "/home/nanoo/dev/static/picture/escalade-pictures/";
    
    /**
     * This method is use to upload pictures, write them on disk and return their paths.
     *
     * @param picture multipart file uploaded
     * @param name name
     * @param date current date
     * @return file path
     */
    public String doUpload(MultipartFile picture, String name, String date, String publication) {
        
        if (!new File(REAL_PATH + publication + "/").exists()) {
            new File(REAL_PATH + publication + "/").mkdirs();
        }
        
        try{
            InputStream in = picture.getInputStream();
            
            // server upload
            File serverDestination = new File(REAL_PATH + publication + "/" + formatString(date) + "_" + formatString(name) + ".jpg");
            FileUtils.copyInputStreamToFile(in,serverDestination);
            
            in.close();
        }catch (IOException e){
            log.error(e.getMessage());
        }
        
        return ABS_PATH + publication + "/" + formatString(date) + "_" + formatString(name) + ".jpg";
    }
    
    /**
     * This method remove some characters from a string
     *
     * @param string string to manipulate
     * @return the string reformatted
     */
    private String formatString (String string)
    {
        return string.replace("/","_").replace(" ","_").replace(":","_");
    }
    
    
}
