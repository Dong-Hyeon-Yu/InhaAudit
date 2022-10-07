package com.inha.fabricApp.utils.identity;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;

public interface PrivateKeyRepository {

    PrivateKey getPrivateKey(String userId) throws IOException, InvalidKeyException;
}
