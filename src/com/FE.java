package com;
import Exception.*;
import java.util.ArrayList;

public interface FE {
    ArrayList<User> listingUsers() throws NoException;
    User consultingUser(Integer id) throws NoException, InvalidException;
    ArrayList<Resource> listingResources() throws NoException;
    Resource consultingResource(Integer id) throws  NoException, InvalidException;
    Registry registryuser(String email, String password) throws NoException, RepetedException, InvalidException;
    String loginUser(String email, String password) throws NoException,InvalidException;
}