package com.library.api.config;

import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RavenDBConfig {

    @Bean
    public IDocumentStore documentStore() {
        final String[] urls = { "http://127.0.0.1:8080" };
        final String databaseName = "Library";

        DocumentStore store = new DocumentStore(urls, databaseName);
        store.initialize();

        return store;
    }

    @Bean
    @Scope("prototype")
    public IDocumentSession documentSession(IDocumentStore store) {
        return store.openSession();
    }
}