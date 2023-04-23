package com.guptaji.repository;

import com.guptaji.entity.GenericJsonTestingEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JsonTestingRepo implements PanacheRepositoryBase<GenericJsonTestingEntity, Long> {
}
