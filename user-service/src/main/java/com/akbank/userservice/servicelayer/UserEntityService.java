package com.akbank.userservice.servicelayer;

import com.akbank.core.BaseEntityService;
import com.akbank.userservice.entity.User;
import com.akbank.userservice.dao.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService extends BaseEntityService<User, IUserRepository> {

    public UserEntityService(IUserRepository repository) {
        super(repository);
    }
}
