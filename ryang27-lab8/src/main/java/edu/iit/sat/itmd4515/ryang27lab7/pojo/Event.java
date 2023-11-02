package edu.iit.sat.itmd4515.ryang27lab7.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName event
 */
@Data
@Entity
@Table(name = "event")
public class Event implements Serializable {
    /**
     * 
     */
    @Column
    private String name;

    /**
     * 
     */
    @Column
    private Date date;

    /**
     * 
     */

    @Column
    private String type;

    /**
     * 
     */
    @Column
    private String remark;

    @Column
    @Id
    private Integer id;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Event other = (Event) that;
        return (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))

                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());

        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", date=").append(date);
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}