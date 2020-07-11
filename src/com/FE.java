package com;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import Exception.*;


public interface FE {
    ArrayList<User> listingUsers() throws NoException;
    User consultingUser(Integer id) throws NoException, InvalidException;
    ArrayList<Resource> listingResources() throws NoException;
    Resource consultingResource(Integer id) throws  NoException, InvalidException;
    Registry registryuser(String email, String password) throws NoException, RepeatedException, InvalidException;
    String loginUser(String email, String password) throws NoException,InvalidException;
}
