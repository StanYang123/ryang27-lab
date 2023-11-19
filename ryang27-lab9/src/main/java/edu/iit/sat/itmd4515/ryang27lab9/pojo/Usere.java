package edu.iit.sat.itmd4515.ryang27lab9.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Wang.Kone
 * @date 2023/11/2 15:07
 */

@Data
@Entity
@Table(name = "usere")
public class Usere implements Serializable {

    @Id
    private Integer id;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;
}
