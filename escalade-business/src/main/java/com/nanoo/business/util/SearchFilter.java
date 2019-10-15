package com.nanoo.business.util;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nanoo
 * @create 23/09/2019 - 19:33
 */
@Data @NoArgsConstructor
public class SearchFilter {

    /* criteria recover from site and topo search forms */
    private boolean officialLabel;
    private boolean lendable;
    private String region;
    private String publication;
    private String sectorNbrMin;
    private String rating;

}
