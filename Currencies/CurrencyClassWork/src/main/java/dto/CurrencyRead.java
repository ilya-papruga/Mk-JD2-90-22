package dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = CurrencyCreate.class)
public class CurrencyRead {

    private long id;

    private String name;

    private String description;

    private String code;

    private LocalDateTime dtCreate;

    private LocalDateTime dtUpdate;

    public CurrencyRead(long id, String name,
                        String description,
                        String code, LocalDateTime dtCreate,
                        LocalDateTime dtUpdate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }
}
