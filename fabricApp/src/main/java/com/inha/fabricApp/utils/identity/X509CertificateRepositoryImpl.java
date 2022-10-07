package com.inha.fabricApp.utils.identity;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import org.hyperledger.fabric.gateway.Identities;
import org.springframework.stereotype.Repository;

@Repository
public class X509CertificateRepositoryImpl implements X509CertificateRepository {

    private static final String DEFAULT_CERTIFICATE_BASE_PATH = "";

    @Override
    public X509Certificate getCertificate(String userId)
            throws IOException, CertificateException {

        Reader certReader = Files.newBufferedReader(Path.of(DEFAULT_CERTIFICATE_BASE_PATH, userId));
        return Identities.readX509Certificate(certReader);
    }
}
