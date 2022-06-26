package core.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import core.EStatus;
import jakarta.persistence.*;
import service.StatusCodeCount;

import java.time.OffsetDateTime;
@Entity

@NamedNativeQuery(
        name = "StatusCodes",
        query = "select o.status, count(o.id) as count from orders o group by o.status",
        resultSetMapping = "PostWithCommentByRankMapping"
)
@SqlResultSetMapping(
        name = "PostWithCommentByRankMapping",
        classes = {
                @ConstructorResult(columns = {
                @ColumnResult(name = "status", type = EStatus.class),
                @ColumnResult(name = "count", type = int.class)
        },
        targetClass = StatusCodeCount.class)
}
)

@Table(name ="orders", schema = "main")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "date_create")
    private OffsetDateTime dtCreate;
    @Column(name = "date_update")
    @Version
    private OffsetDateTime dtUpdate;
    @Column(name = "pet_id")
    private Long petId;
    private int quantity;
    @Column(name = "ship_date")
    private OffsetDateTime shipDate;

    @Enumerated(EnumType.STRING)
    private EStatus status;
    private boolean complete;

    public Order() {
    }

    public Order(Long id, OffsetDateTime dtCreate, OffsetDateTime dtUpdate, Long petId, int quantity,
                 OffsetDateTime shipDate, core.EStatus status, boolean complete) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
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

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
