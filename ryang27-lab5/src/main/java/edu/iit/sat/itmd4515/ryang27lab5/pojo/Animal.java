package edu.iit.sat.itmd4515.ryang27lab5.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 
 * @TableName animal
 */
@TableName(value ="animal")
@Data
@Entity
public class Animal implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    @Id
    private Integer aid;

    /**
     * 
     */
    private String aname;

    /**
     * 
     */
    private Integer anum;

    /**
     * 
     */
    private String ename;

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
        Animal other = (Animal) that;
        return (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getAname() == null ? other.getAname() == null : this.getAname().equals(other.getAname()))
            && (this.getAnum() == null ? other.getAnum() == null : this.getAnum().equals(other.getAnum()))
            && (this.getEname() == null ? other.getEname() == null : this.getEname().equals(other.getEname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getAname() == null) ? 0 : getAname().hashCode());
        result = prime * result + ((getAnum() == null) ? 0 : getAnum().hashCode());
        result = prime * result + ((getEname() == null) ? 0 : getEname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aid=").append(aid);
        sb.append(", aname=").append(aname);
        sb.append(", anum=").append(anum);
        sb.append(", ename=").append(ename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}