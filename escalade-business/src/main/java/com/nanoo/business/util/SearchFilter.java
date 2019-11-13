package com.nanoo.business.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nanoo
 * @create 23/09/2019 - 19:33
 */
@Getter @Setter
@NoArgsConstructor
public class SearchFilter {

    /* criteria recover from site and topo search forms */
    private boolean officialLabel;
    private boolean lendable;
    private String region;
    private String publication;
    private String sectorNbrMin;
    private String rating;

}
