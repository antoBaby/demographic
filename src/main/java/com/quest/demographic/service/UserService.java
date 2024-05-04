package com.quest.demographic.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.quest.demographic.dao.UserRepository;
import com.quest.demographic.dto.UserDTO;
import com.quest.demographic.model.User;
import com.quest.demographic.utils.CommonConstant;
import com.quest.demographic.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private CommonUtils commonUtils;
    @Autowired
    private UserRepository userRepository;


    @Transactional
    public String userRegister(UserDTO userDTO) {
        User user = (User) this.commonUtils.convertIntoObject(userDTO, User.class);
        user.setCreateDate(LocalDateTime.now());
        Optional<User> byId = userRepository.findById(user.getName());
        if (byId.isEmpty())
            userRepository.save(user);
        else
            return CommonConstant.RECORD_EXISTS;

        return CommonConstant.RECORD_SAVED;
    }

    public List<UserDTO> viewall() {
        List<User> users = this.userRepository.findAll(Sort.by(Sort.Direction.DESC, "createDate"));
        List<UserDTO> userDTOS = (List<UserDTO>) commonUtils.convertIntoList(users, new TypeReference<List<UserDTO>>() {
        });

        return userDTOS;
    }


}
