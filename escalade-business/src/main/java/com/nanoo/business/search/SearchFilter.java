package com.nanoo.business.search;

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
    private String sectorNbr;
    private String rating;

}
