package pt.bmo.restaurant.ordering.auth.model;

import pt.bmo.restaurant.ordering.auth.enums.UserRole;

public class User {
    private Integer id;
    private String name;
    private String pwd;
    private UserRole role;
}
