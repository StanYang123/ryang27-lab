package edu.iit.sat.itmd4515.ryang27lab10.pojo;

import lombok.Data;

import javax.persistence.Column;
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
    @Column
    private Integer id;

    /**
     *
     */
    @Column
    private String username;

    /**
     *
     */
    @Column
    private String password;
}
