package com.ampro.robinhood.endpoint.authorize;

import com.ampro.robinhood.endpoint.ApiElement;
import com.ampro.robinhood.endpoint.RobinhoodEnum;
import com.google.gson.annotations.SerializedName;

/**
 * A wrapper for both possible API login responses.
 * It holds a token {@link String}, {@link MultifactorType multifactor auth type}
 * and whether multifactor is required for the account.
 * <br>
 *     MultifactorAuthorization (or Two-factor Authorization) is referred to as
 *     {@code mfa} by the Robinhood Api. (Robinhood calls it Two-Factor, but the
 *     Api calls it multifactor...).
 *
 * @author Jonathan Augustine
 * @since 0.8.4
 */
public class AuthorizationData implements ApiElement {

    /**
     * A wrapper for deserializing token strings from Robinhood
     * @author Conrad Weisse
     */
    public static class Token implements ApiElement {
        /** The actual authorization token string */
        private String token;
        /** @return The actual authorization token string */
        public String getToken() { return this.token; }
        /** @return The actual authorization token string */
        @Override
        public String toString() { return this.token; }
    }

    /**
     * A wrapper for the types of multifactor authorizations.
     * @author Jonathan Augustine
     */
    public enum MultifactorType implements RobinhoodEnum {
        SMS("sms"),
        APP("app");

        private String value;
        MultifactorType(String s) { value = s; }

        /**
         * Parse a {@link MultifactorType} from a string from the Robinhood Api.
         * @param s The string to parse
         * @return The parsed {@link MultifactorType} or null
         */
        public static MultifactorType parse(String s) {
            switch (s) {
                case "sms": return SMS;
                case "app": return APP;
                default: return null;
            }
        }

        @Override
        public String getValue() { return value; }

        @Override
        public String toString() { return value; }
    }
    
    /** The authorization token used to authorize private ApiMethods */
    @SerializedName("access_token")   private String token;
    
    @SerializedName("refresh_token")  private String refreshToken;
    
    @SerializedName("scope")          private String scope;
    
    @SerializedName("token_type")     private String tokenType;
    
    @SerializedName("backup_code")    private String backupCode;
    
    @SerializedName("expires_in")     private int expiresIn;
    
    /** The multifactor authorization code to enable login */
    @SerializedName("mfa_code")       private String mfaCode;

    /** The type of multifactor authorization */
    @SerializedName("mfa_type")       private String mfaType;

    /** Whether multifactor is required to login */
    @SerializedName("mfa_required")   private boolean isMfaRequired = false;
    

    /** @return The authorization token used to authorize private ApiMethods */
    public String getToken() {
        return token;
    }

    /**
     * Set the token used to authorize private ApiMethods.
     * @param newToken The new token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Set the token used to authorize private ApiMethods.
     * @param newToken The new token
     */
    public void setToken(Token newToken) {
        this.token = newToken.getToken();
    }

    /** @return Whether multifactor authorization is required to log in */
    public boolean mfaRequired() {
        return isMfaRequired;
    }

    /** @return The {@link MultifactorType} needed to login */
    public MultifactorType getMfaType() {
        return MultifactorType.parse(mfaType);
    }

    /**
     * @return the refresh_token
     */
    public String getRefreshToken()
    {
        return refreshToken;
    }

    /**
     * @param refresh_token the refresh_token to set
     */
    public void setRefreshToken(String refreshToken)
    {
        this.refreshToken = refreshToken;
    }

    /**
     * @return the scope
     */
    public String getScope()
    {
        return scope;
    }

    /**
     * @param scope the scope to set
     */
    public void setScope(String scope)
    {
        this.scope = scope;
    }

    /**
     * @return the token_type
     */
    public String getTokenType()
    {
        return tokenType;
    }

    /**
     * @param token_type the token_type to set
     */
    public void setTokenType(String tokenType)
    {
        this.tokenType = tokenType;
    }

    /**
     * @return the backup_code
     */
    public String getBackupCode()
    {
        return backupCode;
    }

    /**
     * @param backup_code the backup_code to set
     */
    public void setBackupCode(String backupCodes)
    {
        this.backupCode = backupCode;
    }

    /**
     * @return the expires_in
     */
    public int getExpiresIn()
    {
        return expiresIn;
    }

    /**
     * @param expires_in the expires_in to set
     */
    public void setExpiresIn(int expiresIn)
    {
        this.expiresIn = expiresIn;
    }

    /**
     * @return the mfa_code
     */
    public String getMfaCode()
    {
        return mfaCode;
    }

    /**
     * @param mfa_code the mfa_code to set
     */
    public void setMfaCode(String mfaCode)
    {
        this.mfaCode = mfaCode;
    }
    
    
    /** @return [TOKEN=%s][MFA_CODE=%s][MFA_TYPE=%s][MFA_REQUIRED=%s] */
    @Override
    public String toString() {
        return String.format("[TOKEN=%s][MFA_CODE=%s][MFA_TYPE=%s][MFA_REQUIRED=%s]",
                             token, mfaCode, mfaType, isMfaRequired);
    }
}
