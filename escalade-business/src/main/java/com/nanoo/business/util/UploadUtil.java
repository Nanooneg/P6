package com.nanoo.business.util;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author nanoo
 * @create 14/10/2019 - 12:22
 */
public class UploadUtil {
    
    private static final Logger log = LoggerFactory.getLogger(UploadUtil.class);
    
    
    private static final String APP_PATH = "/resources/";
    private static final String SERVER_PATH = "/home/nanoo/dev/static/picture/escalade-pictures/";
    
    /**
     * This method is use to upload pictures, write them on disk and return their paths.
     *
     * @param picture multipart file uploaded
     * @param name name
     * @param date current date
     * @return file path
     */
    public String doUpload(MultipartFile picture, String name, String date, String publication) {
        
        if (!new File(SERVER_PATH + publication + "/").exists()) {
            new File(SERVER_PATH + publication + "/").mkdirs();
        }
        
        try{
            InputStream in = picture.getInputStream();
            
            File serverDestination = new File(SERVER_PATH + publication + "/" + formatString(date) + "_" + formatString(name) + ".jpg");
            FileUtils.copyInputStreamToFile(in,serverDestination);
            
            in.close();
        }catch (IOException e){
            log.error(e.getMessage());
        }
        
        return APP_PATH + publication + "/" + formatString(date) + "_" + formatString(name) + ".jpg";
    }
    
    /**
     * This method replaces some characters from a string
     *
     * @param string string to manipulate
     * @return the string reformatted
     */
    private String formatString (String string)
    {
        return string.replace("/","_").replace(" ","_").replace(":","_");
    }
    
    /**
     * This method erase old picture when publication is updated
     *
     * @param oldPicturePath old picture path
     */
    public static void eraseOldPicture(String oldPicturePath){
        if (oldPicturePath != null){
            try{
                String realPicturePath = oldPicturePath.replace(APP_PATH,SERVER_PATH);
                Files.delete(Paths.get(realPicturePath));
            }catch (IOException e){
                log.error(e.getMessage());
            }
        }
    }
}
