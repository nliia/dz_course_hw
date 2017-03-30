package ru.kpfu.itis.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.forms.UserForm;
import ru.kpfu.itis.model.*;
import ru.kpfu.itis.service.AutosService;
import ru.kpfu.itis.service.DriversService;
import ru.kpfu.itis.service.PassengersService;
import ru.kpfu.itis.service.UsersService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UsersController {
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    UsersService usersService;

    @Autowired
    DriversService driversService;

    @Autowired
    AutosService autosService;

    @Autowired
    PassengersService passengersService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        Long sessionUid = (Long) request.getSession().getAttribute("session_uid");
        if (sessionUid != null) {
            return "redirect:/";
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String nickname,
                        @RequestParam String password) {
        User user = usersService.findByNickname(nickname);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("session_uid", user.getId());
        }
        return "redirect: /home";

    }
    /*
    TODO: обработать форму авторизации. Использовать метод findByNickname у userService.
    При авторизации нужно положить session_uid в сессию, для маяка, что пользователь уже авторизован
     */

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationGet(ModelMap modelMap) {
        Long sessionUid = (Long) request.getSession().getAttribute("session_uid");
        if (sessionUid != null) {
            return "redirect:/";
        }
        modelMap.put("regForm", new UserForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationPost(@ModelAttribute("user") UserForm regForm) throws IOException {
        String password = regForm.getPassword();
        String passwordConfirmation = regForm.getPasswordConfirmation();
        if (password.equals(passwordConfirmation)) {
            User user = new User();
            user.setNickname(regForm.getNickname());
            user.setPassword(encoder.encode(password));
            user.setFirstname(regForm.getFirstname());
            user.setSurname(regForm.getSurname());
            user.setEmail(regForm.getEmail());
            user.setRole("passenger");
            usersService.addUser(user);
            passengersService.addPassenger(new Passenger(0, user));
        }
        return "redirect:/login";
        /*TODO: сохранить пользователя в бд.
        По дефолту, новый пользователь является пассажиром.
            пароль должен храниться в зашифрованном виде.
         */
    }

    @RequestMapping(value = "/users/{userId:\\d+}", method = RequestMethod.GET)
    public String profile(ModelMap modelMap, @PathVariable Long userId
    ) {
        Long sessionUid = (Long) request.getSession().getAttribute("session_uid");
        if (sessionUid == null) {
            return "login";
        }
        User userInfo = usersService.findById(userId);
        modelMap.put("userinfo", userInfo);
        if (userInfo.getDriver() != null && userInfo.getDriver().getTrips().size() > 0) {
            List<Trip> tripList = userInfo.getDriver().getTrips();
            List<Trip> driverTrips = new ArrayList<>();
            List<Trip> endDriverTrips = new ArrayList<>();
            for (Trip trip : tripList) {
                if (trip.getStatus().contains("Ожидание")) {
                    driverTrips.add(trip);
                } else if (trip.getStatus().contains("Завершено")) {
                    endDriverTrips.add(trip);
                }
            }
            modelMap.put("driverTrips", driverTrips);
            modelMap.put("endDriverTrips", endDriverTrips);

        }


        List<Trip> tripList = userInfo.getPassenger().getTrips();
        List<Trip> pasTrips = new ArrayList<>();
        List<Trip> endPasTrips = new ArrayList<>();
        for (Trip trip : tripList) {
            if (trip.getStatus().contains("Ожидание")) {
                pasTrips.add(trip);
            } else if (trip.getStatus().contains("Завершено")) {
                endPasTrips.add(trip);
            }
        }
        modelMap.put("pasTrips", pasTrips);
        modelMap.put("endPasTrips", endPasTrips);

        if (userInfo.getDriver() != null) {
            tripList = userInfo.getDriver().getTrips();
            List<Trip> driverTrips = new ArrayList<>();
            for (Trip trip : tripList) {
                if (trip.getStatus().contains("Ожидание")) {
                    driverTrips.add(trip);
                }
            }
            List<Booking> bookings = new ArrayList<>();
            for (Trip trip : driverTrips) {
                for (Booking booking : trip.getBookings()) {
                    if (booking.getConfirm() == null) {
                        bookings.add(booking);
                    }
                }
            }
            modelMap.put("bookings", bookings);
        }

        return "profile";
    }

    @RequestMapping(value = "/newauto", method = RequestMethod.GET)
    public String newAutoPage() {
        return "newauto";
    }

    @RequestMapping(value = "/newauto", method = RequestMethod.POST)
    public String newAuto(@ModelAttribute Automobile automobile) {
        Long userId = (Long) request.getSession().getAttribute("session_uid");
        if (userId == null) {
            return "login";
        }
        User user = usersService.findById(userId);
        Driver driver = user.getDriver();
        if (driver == null) {
            driver = new Driver();
            driver.setUser(user);
            driver.setRating(0);
            driver.setAutomobileList(new ArrayList<Automobile>());
            driver.setExperience(0);
            driversService.addDriver(driver);
            user.setDriver(driver);
            user.setRole("DRIVER");
            usersService.update(user);
        }
        automobile.setDriver(driver);
        autosService.addAuto(automobile);
        return "redirect:/users/" + user.getId();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        request.getSession().removeAttribute("session_uid");
        return "redirect:/";
    }
}

