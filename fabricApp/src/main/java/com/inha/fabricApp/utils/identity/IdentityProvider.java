package com.inha.fabricApp.utils.identity;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.cert.CertificateException;
import org.hyperledger.fabric.gateway.Identity;

public interface IdentityProvider {

    Identity getIdentity(String mspId, String userId)
            throws IOException, InvalidKeyException, CertificateException;
}
