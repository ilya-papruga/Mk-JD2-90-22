package by.it_academy.jd2.ClassWork.person.core;

public enum  StorageType {
    COOKIES,
    SESSION;


    public static StorageType valueOfIgnoreCase(String name){

        for (StorageType type : values()) {

            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }

        }
        throw new IllegalArgumentException("Выбран неверный тип хранилища");

    }

}
