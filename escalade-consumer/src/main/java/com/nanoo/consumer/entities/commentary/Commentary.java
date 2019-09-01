package com.nanoo.consumer.entities.commentary;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:18
 */
public class Commentary implements Serializable {
    
    private Long id;
    private String title;
    private String text;
    private int likeNbr;
    private int dislikeNbr;
    private Long idAccount;
    
}
