package com.kit.csg.crawler.stock.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Robin on 2016/8/31.
 */
@Entity
@Table(name = "POWERECON_STOCKCOMPANYRELATION")
public class POWERECON_STOCKCOMPANYRELATION implements Serializable {
    private String SCID;
    private String STOCKCODE;
    private String LAPC_ID;

    @Id
    @Column(name = "SCID", nullable = false, length = 32)
    public String getSCID() {
        return SCID;
    }

    public void setSCID(String SCID) {
        this.SCID = SCID;
    }

    @Basic
    @Column(name = "STOCKCODE", nullable = true, length = 255)
    public String getSTOCKCODE() {
        return STOCKCODE;
    }

    public void setSTOCKCODE(String STOCKCODE) {
        this.STOCKCODE = STOCKCODE;
    }

    @Basic
    @Column(name = "LAPC_ID", nullable = true, length = 32)
    public String getLAPC_ID() {
        return LAPC_ID;
    }

    public void setLAPC_ID(String LAPC_ID) {
        this.LAPC_ID = LAPC_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        POWERECON_STOCKCOMPANYRELATION that = (POWERECON_STOCKCOMPANYRELATION) o;

        if (SCID != null ? !SCID.equals(that.SCID) : that.SCID != null) return false;
        if (STOCKCODE != null ? !STOCKCODE.equals(that.STOCKCODE) : that.STOCKCODE != null) return false;
        return LAPC_ID != null ? LAPC_ID.equals(that.LAPC_ID) : that.LAPC_ID == null;

    }

    @Override
    public int hashCode() {
        int result = SCID != null ? SCID.hashCode() : 0;
        result = 31 * result + (STOCKCODE != null ? STOCKCODE.hashCode() : 0);
        result = 31 * result + (LAPC_ID != null ? LAPC_ID.hashCode() : 0);
        return result;
    }
}
