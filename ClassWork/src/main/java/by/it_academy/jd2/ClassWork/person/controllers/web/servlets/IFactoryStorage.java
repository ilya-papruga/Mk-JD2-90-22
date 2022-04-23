package by.it_academy.jd2.ClassWork.person.controllers.web.servlets;

import by.it_academy.jd2.ClassWork.person.core.StorageType;

public interface IFactoryStorage {

    IStorage getStorageByType(StorageType type);

}
