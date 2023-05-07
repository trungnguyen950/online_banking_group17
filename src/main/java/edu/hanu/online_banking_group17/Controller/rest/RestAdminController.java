package edu.hanu.online_banking_group17.Controller.rest;

import edu.hanu.online_banking_group17.Model.LoansPackage;
import edu.hanu.online_banking_group17.Model.User;
import edu.hanu.online_banking_group17.Service.LoansService;
import edu.hanu.online_banking_group17.Service.UserService;
import edu.hanu.online_banking_group17.handling_exepctions.DataInvalidException;
import edu.hanu.online_banking_group17.rest.model.ChangeUserStatusInput;
import edu.hanu.online_banking_group17.rest.model.Page;
import edu.hanu.online_banking_group17.rest.model.PagingRequest;
import edu.hanu.online_banking_group17.rest.model.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/rest")
public class RestAdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoansService loansService;

    // list customer
    @PostMapping("/get-customer-list")
    public Page<User> getCustomerList(@RequestBody PagingRequest pagingRequest) {
        return userService.getCustomerList(pagingRequest);
    }

    @PostMapping("/delete-user")
    public ResponseData deleteUser(@RequestParam("id") Long id)
            throws DataInvalidException {
        return ResponseData.ok(userService.deleteUser(id));
    }

    @PostMapping("/change-status")
    public ResponseData changeStatus(@RequestBody ChangeUserStatusInput input)
            throws DataInvalidException {
        return ResponseData.ok(userService.changeStatus(input));
    }

    //TODO: list admin
    @PostMapping("/get-admin-list")
    public Page<User> getAdminList(@RequestBody PagingRequest pagingRequest) {
        return userService.getAdminList(pagingRequest);
    }

//    // edit admin
//    @GetMapping("/edit-user/{id}")
//    public Page<User> editAdmin(@RequestBody PagingRequest pagingRequest) {
//        return userService.editAdmin(pagingRequest);
//    }

    // TODO: manage loans package
    @PostMapping("/get-loans-package-list")
    public Page<LoansPackage> getLoansPackageList(@RequestBody PagingRequest pagingRequest) {
        return loansService.getLoansPackageList(pagingRequest);
    }
}
