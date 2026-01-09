package com.carbon.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("carbon_asset")
public class CarbonAsset implements Serializable {

    @TableId
    private Long assetId;

    private Long ownerId;     // ID người sở hữu
    private String assetType; // Loại tài sản (1: Quota, 2: Credit)
    private BigDecimal amount; // Số lượng tấn CO2
    private String status;    // Trạng thái duyệt
    private Date createTime;  // Ngày tạo

    // --- PHẦN GETTER VÀ SETTER ĐẦY ĐỦ (Dán đè vào là có luôn) ---

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
