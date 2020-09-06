package Connection_Interfaces;

import Class.Authenticate;

public interface Authenticate_connection {
    void Register(Authenticate authenticate) throws Exception;
    void Login(Authenticate authenticate) throws Exception;
}
