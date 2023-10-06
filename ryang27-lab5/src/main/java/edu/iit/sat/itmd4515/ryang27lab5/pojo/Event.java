package edu.iit.sat.itmd4515.ryang27lab5.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName event
 */
@TableName(value ="event")
@Data
@Entity
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
    @Length(min = 1, max = 200, message
            = "About Me must be between 1 and 200 Length")
    @Column
    private String type;

    /**
     * 
     */
    @Length(min = 1, max = 200, message
            = "About Me must be between 1 and 200 Length")
    @Column
    private String remark;

    @Column
    private Integer id;

    @TableField(exist = false)
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