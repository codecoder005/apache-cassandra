package com.popcorn.repository;

import com.popcorn.document.UserDocument;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CassandraRepository<UserDocument, String> {

}
