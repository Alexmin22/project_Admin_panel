package com.example.demo.util;

//import com.example.demo.model.User;
//import com.example.demo.models.Person;
//import com.example.demo.service.user.UserServiceImpl;
//import com.example.demo.services.PersonDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//@Component
//public class UserValidation implements Validator {
//    private final UserServiceImpl userService;
//
//    public UserValidation(UserServiceImpl userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return User.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        User user = (User) target;
//
//        try {
//            userService.load(user.getUsername());
//        } catch (UsernameNotFoundException ignored) {
//            return;
//        }
//
//        errors.rejectValue("username", "","Этот человек есть");
//    }
//}
