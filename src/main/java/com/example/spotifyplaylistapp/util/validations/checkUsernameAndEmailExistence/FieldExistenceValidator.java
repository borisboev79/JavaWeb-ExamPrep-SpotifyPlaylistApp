package com.example.spotifyplaylistapp.util.validations.checkUsernameAndEmailExistence;

import com.example.spotifyplaylistapp.model.binding.UserRegisterModel;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.service.user.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FieldExistenceValidator implements ConstraintValidator<ValidateUniqueFields, UserRegisterModel> {

    private final UserService userService;

    @Autowired
    public FieldExistenceValidator(UserService userService) {
        this.userService = userService;

    }


    @Override
    public void initialize(ValidateUniqueFields constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterModel userRegisterModel, ConstraintValidatorContext constraintValidatorContext) {
        Optional<User> optionalUser = userService.findByUsername(userRegisterModel.getUsername());

        if (optionalUser.isPresent()){
            return false;
        }

        Optional<User> optionalUserEmailCheck = userService.findByEmail(userRegisterModel.getEmail());

        return optionalUserEmailCheck.isEmpty();

    }
}
