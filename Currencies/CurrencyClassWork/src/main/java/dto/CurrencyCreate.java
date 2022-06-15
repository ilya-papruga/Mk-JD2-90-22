package dto;


public class CurrencyCreate {

    private long id;
    private String name;
    private String description;
    private String code;

    public CurrencyCreate() {
    }

    public CurrencyCreate(String name, String description, String code) {
        this.name = name;
        this.description = description;
        this.code = code;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}