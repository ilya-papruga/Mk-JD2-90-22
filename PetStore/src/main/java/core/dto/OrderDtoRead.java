package core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import core.EStatus;
import jakarta.persistence.Column;

import java.time.OffsetDateTime;

public class OrderDtoRead {

    private Long id;

    private OffsetDateTime dtCreate;
    private OffsetDateTime dtUpdate;
    private Long petId;
    private int quantity;
    private OffsetDateTime shipDate;
    private EStatus EStatus;
    private boolean complete;

    public OrderDtoRead() {
    }

    public OrderDtoRead(Long id, OffsetDateTime dtCreate, OffsetDateTime dtUpdate, Long petId, int quantity, OffsetDateTime shipDate, core.EStatus EStatus, boolean complete) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.EStatus = EStatus;
        this.complete = complete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(OffsetDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public OffsetDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(OffsetDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OffsetDateTime getShipDate() {
        return shipDate;
    }

    public void setShipDate(OffsetDateTime shipDate) {
        this.shipDate = shipDate;
    }

    public core.EStatus getEStatus() {
        return EStatus;
    }

    public void setEStatus(core.EStatus EStatus) {
        this.EStatus = EStatus;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
