package com.inha.fabricApp.utils.identity;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import org.hyperledger.fabric.gateway.Identity;
import org.hyperledger.fabric.gateway.impl.identity.X509IdentityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityProviderImpl implements IdentityProvider {

    private final X509CertificateRepository certificateRepository;
    private final PrivateKeyRepository privateKeyRepository;

    @Autowired
    public IdentityProviderImpl(
            X509CertificateRepository certificateRepository,
            PrivateKeyRepository privateKeyRepository) {

        this.certificateRepository = certificateRepository;
        this.privateKeyRepository = privateKeyRepository;
    }


    @Override
    public Identity getIdentity(String mspId, String userId)
            throws IOException, InvalidKeyException, CertificateException {

        X509Certificate certificate = certificateRepository.getCertificate(userId);
        PrivateKey privateKey = privateKeyRepository.getPrivateKey(userId);

        return new X509IdentityImpl(mspId, certificate, privateKey);
    }
}
