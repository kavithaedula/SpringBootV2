package org.oclc.lhrapi.lhrapiplatform.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.LinkedHashMap;
import java.util.Map;

@Component("AuthenticationSpringSecurity")
public class AuthenticationSpringSecurity {

    @PreAuthorize("hasPermission(#, 'group:action')")
    public Map isReadClaimAuthenticated(Authentication authentication) {
        return validateAuthentication(authentication);
    }

    @PreAuthorize("hasPermission(#, 'group:action')")
    public Map isWriteClaimAuthenticated(Authentication authentication) {
        return validateAuthentication(authentication);
    }


    private Map validateAuthentication(Authentication authentication) {
       /* WebAuthenticationDetails authenticationDetails =
                (WebAuthenticationDetails) authentication.getDetails();*/

        Map<String, Object> json = new LinkedHashMap<>();
     /*   json.put("authenticated", authentication.isAuthenticated());

        if (authenticationDetails.getSecurityContext() != null) {

            SecurityContext securityContext = authenticationDetails.getSecurityContext();


            RelyingPartyId rpid = securityContext.getRelyingParty();
            PPID ppid = securityContext.getPPID();

            Map<String, String> userIdentityJson = new LinkedHashMap<>();
            userIdentityJson.put("", institutionId.getValue().toString());
            userIdentityJson.put("", rpid.getValue());
            userIdentityJson.put("", ppid.getValue());

            json.put("userIdentity", userIdentityJson);
        }*/
        return json;
    }
}

