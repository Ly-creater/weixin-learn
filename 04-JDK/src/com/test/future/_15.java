package com.test.future;
/*
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.future
 * @Author: jkl
 * @CreateTime: 2021
 * @Description: jdk15特性
 */

import java.security.InvalidKeyException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

/**
 *
 */
public class _15 {
    /**
     *  EdDSA 数字签名算法
     * @throws SignatureException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     */
    //public void edDsaTest() throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, InvalidKeySpecException {
    //    KeyPairGenerator ed25519 = KeyPairGenerator.getInstance("Ed25519");
    //    KeyPair keyPair = ed25519.generateKeyPair();
    //    Signature sig=Signature.getInstance("Ed25519");
    //    sig.initSign(keyPair.getPrivate());
    //    sig.update("hello".getBytes(StandardCharsets.UTF_8));
    //    byte[] s = sig.sign();
    //}


    /**
     * 密封类的使用，可以指定允许继承的子类
     */
    //public abstract sealed class Pet permits Cat, Dog {}
    //
    ///**
    // * 允许继承的子类必须指定是否可以扩展
    // *      final或non-sealed修饰
    // */
    //public final class Cat extends Pet {}
    //public non-sealed class Dog extends Pet {}


    /**
     * 隐藏类的添加
     * 此功能可帮助需要在运行时生成类的框架。框架生成类需要动态扩展其行为，但是又希望限制对这些类的访问。
     * 隐藏类很有用，因为它们只能通过反射访问，而不能从普通字节码访问。
     * 此外，隐藏类可以独立于其他类加载，这可以减少框架的内存占用。这是一个新的功能。
     */

    public static void main(String[] args) {
        Emp smith = new Emp("smith");
        System.out.println(smith.toString());
        System.out.println("是否属于Recode的子类:"+Record.class.isAssignableFrom(smith.getClass()));
        System.out.println("是否属于Recode的子类:"+smith.getClass().isRecord());

    }
}
