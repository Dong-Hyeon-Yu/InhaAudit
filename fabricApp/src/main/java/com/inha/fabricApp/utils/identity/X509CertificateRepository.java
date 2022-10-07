package com.inha.fabricApp.utils.identity;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public interface X509CertificateRepository {

    X509Certificate getCertificate(String userId) throws IOException, CertificateException;
}
