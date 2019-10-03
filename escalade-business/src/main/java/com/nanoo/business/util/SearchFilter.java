package com.nanoo.business.util;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nanoo
 * @create 23/09/2019 - 19:33
 */
@Data @NoArgsConstructor
public class SearchFilter {

    private boolean officialLabel;
    private String region;
    private String sectorNbrMin;
    private String ratingMin;

}