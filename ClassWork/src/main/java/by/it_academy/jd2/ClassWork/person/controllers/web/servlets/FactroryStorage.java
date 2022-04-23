package by.it_academy.jd2.ClassWork.person.controllers.web.servlets;

import by.it_academy.jd2.ClassWork.person.core.StorageType;

public class FactroryStorage implements IFactoryStorage {

    @Override
    public IStorage getStorageByType(StorageType type) {
        if (type.equals(StorageType.SESSION)) {
            return new SessionStorage();
        } else if (type.equals(StorageType.COOKIES)) {
            return new CookieStorage();
        } else {
            throw new IllegalStateException("Нет реализации для данного хранилища");
        }
    }
}
