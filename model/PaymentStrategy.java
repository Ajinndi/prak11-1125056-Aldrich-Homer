package model;

import java.util.*;

public interface PaymentStrategy {
    boolean validate(double amount);

    boolean canPay(double amount);

    void pay(double amount);
    
    List<AuthorizationMethod> getRequiredAuthorizations();

    AuthorizationStrategy getAuthorizationStrategy(AuthorizationMethod method);

    String getPaymentName();
}
