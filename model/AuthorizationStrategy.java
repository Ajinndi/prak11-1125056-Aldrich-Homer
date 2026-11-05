package model;

public interface AuthorizationStrategy {
    boolean validate(String credential);
}