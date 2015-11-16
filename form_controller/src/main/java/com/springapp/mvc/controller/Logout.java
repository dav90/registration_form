package com.springapp.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

//@Controller
public class Logout {
//    @Autowired
//    private HttpServletRequest request;
//
//    @Autowired
//    private UserManagerMySql userRepositoryMySql;
//
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String setUserOffline(Model model) {
//
//        User user = (User) request.getSession().getAttribute("currentUser");
//        if (user != null) {
//            User onlineUser = userRepositoryMySql.findUserByEmail(user.getEmail());
//            onlineUser.setOnline(false);
//            request.getSession().invalidate();
//        }
//        model.addAttribute("user", new User());
//        return "redirect:login";
//    }

}
