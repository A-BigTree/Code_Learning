/**
 * ==================================================
 * Project: springMVC_project
 * Package: seu.mvc.entity
 * =====================================================
 * Title: Movie.java
 * Created: [2023/4/7 11:01] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/7, created by Shuxin-Wang.
 * 2.
 */

package seu.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String movieId;
    private String movieName;
    private Double moviePrice;

}