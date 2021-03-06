package com.springapp.mvc.controller;

import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;

import com.springapp.mvc.service.impl.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "addAddress")
public class AddAddress {
    @RequestMapping(method = RequestMethod.GET)
    private String initContactForm(Model model, User user) {
        model.addAttribute("user", user);
        return "addAddress";
    }

    @Autowired
    UserManager manager;

    @Autowired
    HttpServletRequest request;


    @RequestMapping(method = RequestMethod.POST)
    private String addContactToUser(HttpServletRequest request,
                                    @RequestParam(value = "city") String city,
                                    @RequestParam(value = "street") String street) {
        String path = "userHome";
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (StringUtils.isEmpty(city) && StringUtils.isEmpty(street)) {
            path = "addAddress";
        } else {
            Address address = new Address();
            address.setCity(city);
            address.setStreet(street);
            User contactUser= manager.findUserByEmail(currentUser);
            List<Address> addressList = contactUser.getAddress();
            addressList.add(address);
            contactUser.setAddress(addressList);
            manager.editUser(contactUser);

        }

        return "redirect:" + path;
    }


}
