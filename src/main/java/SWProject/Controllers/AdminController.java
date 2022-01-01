package SWProject.Controllers;

import SWProject.classes.IRegistrationRequest;
import SWProject.classes.ISuspendableUser;
import SWProject.classes.SystemData;
import SWProject.classes.Admin;
import SWProject.classes.AdminAuthenticator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    Admin admin;

    @PutMapping("/admin/Login")
    public void Login(@RequestAttribute String username, @RequestAttribute String password) throws Exception {
        admin = (Admin) AdminAuthenticator.getInstance().login(username, password);
    }

    @GetMapping("/admin/listPendingRegistrations")
    public String listPendingRegistrations() {
        return admin.listPendingRegistrations();
    }

    @PutMapping("/admin/verifyDriverRegistration/{requestNumber}")
    public void verifyDriverRegistration(@PathVariable int requestNumber) {
        IRegistrationRequest request = SystemData.getInstance().getRegistrationRequest(requestNumber - 1);
        admin.verifyDriverRegistration(request);

    }

    @PutMapping("/admin/denyDriverRegistration/{requestNumber}")
    public void denyDriverRegistration(@PathVariable int requestNumber) {
        IRegistrationRequest request = SystemData.getInstance().getRegistrationRequest(requestNumber - 1);
        admin.denyDriverRegistration(request);

    }

    @PutMapping("/admin/suspendUser/{username}")
    public void suspendUser(@PathVariable String username) throws Exception {
        ISuspendableUser userToSuspend;
        if (SystemData.getInstance().getDriver(username) != null) {
            userToSuspend = SystemData.getInstance().getDriver(username);
        } else if (SystemData.getInstance().getPassenger(username) != null) {
            userToSuspend = SystemData.getInstance().getPassenger(username);
        }
        else {
            throw new Exception("ERROR: there is no user with this username!");
        }
        admin.suspendUser(userToSuspend);
    }

    @PutMapping("/admin/unsuspendUser/{username}")
    public void unsuspendUser(@PathVariable String username) throws Exception {
        ISuspendableUser userToUnsuspend;
        if (SystemData.getInstance().getDriver(username) != null) {
            userToUnsuspend = SystemData.getInstance().getDriver(username);
        } else if (SystemData.getInstance().getPassenger(username) != null) {
            userToUnsuspend = SystemData.getInstance().getPassenger(username);
        }
        else {
            throw new Exception("ERROR: there is no user with this username!");
        }
        admin.unsuspendUser(userToUnsuspend);
    }

    @PostMapping("/admin/addDiscountToArea/{area}")
    public void addDiscountToArea(@PathVariable String area) {
        admin.addDiscountToArea(area);
    }

    @GetMapping("/admin/listAllRideRequests")
    public String listAllRideRequests(){
        return admin.listAllRideRequests();
    }

    @GetMapping("/admin/showEventsOnRide/{index}")
    public String showEventsOnRide(@PathVariable int index) {
        return admin.showEventsOnRide(SystemData.getInstance().getRideRequest(index));
    }

}