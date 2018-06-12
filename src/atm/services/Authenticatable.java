package atm.services;

public interface Authenticatable {
    byte[] getPassword();

    byte[] getSalt();
}
