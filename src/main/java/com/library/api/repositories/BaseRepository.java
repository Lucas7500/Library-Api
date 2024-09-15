package com.library.api.repositories;

import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseRepository<T> {

    @Autowired
    protected IDocumentStore store;

    protected IDocumentSession openSession() {
        return store.openSession();
    }

    public abstract T get(String objectId);

    public abstract List<T> getAll();

    public abstract T save(T object);

    public abstract void update(T object);

    public abstract void delete(String objectId);
}
