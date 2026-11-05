package model;

import java.util.*;

public interface PaymentStrategy {
    boolean validate(double amount);

    boolean canPay(double amount);

    void pay(double amount);
    
    List<AuthorizationMethod> getRequiredAuthorizations();

    boolean validateAuthorization(AuthorizationMethod method, String credential);

    String getPaymentName();
}
