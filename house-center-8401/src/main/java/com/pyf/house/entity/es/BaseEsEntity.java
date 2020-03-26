package com.pyf.house.entity.es;

public abstract class BaseEsEntity {

    public abstract Object id();

    public abstract String indexName();

    public abstract String type();

    public abstract Class clazz();
}
