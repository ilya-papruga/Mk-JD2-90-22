package core.dto;

import java.time.OffsetDateTime;

public class OrderDtoCreate {


    private Long petId;
    private int quantity;
    private OffsetDateTime shipDate;

    public OrderDtoCreate() {
    }

    public OrderDtoCreate(Long petId, int quantity, OffsetDateTime shipDate) {
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
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
}
