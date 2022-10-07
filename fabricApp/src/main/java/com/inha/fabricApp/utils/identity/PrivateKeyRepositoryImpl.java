package com.inha.fabricApp.utils.identity;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import org.hyperledger.fabric.gateway.Identities;
import org.springframework.stereotype.Repository;

@Repository
public class PrivateKeyRepositoryImpl implements PrivateKeyRepository {

    private static final String DEFAULT_CERTIFICATE_BASE_PATH = "";

    @Override
    public PrivateKey getPrivateKey(String userId) throws IOException, InvalidKeyException {

        Reader keyReader = Files.newBufferedReader(Path.of(DEFAULT_CERTIFICATE_BASE_PATH, userId));
        return Identities.readPrivateKey(keyReader);
    }
}
