package edu.iit.sat.itmd4515.ryang27lab6.pojo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 
 * @TableName city
 */
@Data
@Table(name = "city")

@Entity
public class City implements Serializable {
    /**
     * 
     */
    @Id
    private Integer cid;

    /**
     * 
     */
    private String cname;

    /**
     * 
     */
    private String ctype;

    /**
     * 
     */
    private String ename;

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
        City other = (City) that;
        return (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getCtype() == null ? other.getCtype() == null : this.getCtype().equals(other.getCtype()))
            && (this.getEname() == null ? other.getEname() == null : this.getEname().equals(other.getEname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getCtype() == null) ? 0 : getCtype().hashCode());
        result = prime * result + ((getEname() == null) ? 0 : getEname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", cname=").append(cname);
        sb.append(", ctype=").append(ctype);
        sb.append(", ename=").append(ename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}