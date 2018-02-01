package com.jsystems.mockitoPacket;

import com.jsystems.mockitoPacket.UserMock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMockReposytory extends CrudRepository<UserMock, Long> {
}
