package model;

public class CcvAuthorizationStrategy implements AuthorizationStrategy {
    private String ccv;

    public CcvAuthorizationStrategy(String ccv) {
        this.ccv = ccv;
    }

    @Override
    public boolean validate(String credential) {
        return ccv.equals(credential);
    }
}