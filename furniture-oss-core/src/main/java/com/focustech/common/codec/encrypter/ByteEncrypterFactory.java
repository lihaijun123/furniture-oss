/*
 * Copyright 2010 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focustech.common.codec.encrypter;

import com.focustech.common.utils.StringUtils;

/**
 * 单例模式& 工厂模式
 *
 * @author zhoufengbo
 */
public class ByteEncrypterFactory implements EncrypterFactory {

    private static ByteEncrypterFactory factory = new ByteEncrypterFactory();

    public static ByteEncrypterFactory getInstance() {
        return factory;
    }

    private ByteEncrypterFactory() {

    }

    @Override
    public Encrypter getEncrypter(String algorithm) {
        if (StringUtils.equals(algorithm, EncrypterFactory.TYPE.PBEWithMD5AndDES.name())) {
            return new DESByteEncrypter();
        }
        if (StringUtils.equals(algorithm, EncrypterFactory.TYPE.PBEWithMD5AndTripleDES.name())) {
            return new TriDESByteEncrypter();
        }
        return null;
    }
}
