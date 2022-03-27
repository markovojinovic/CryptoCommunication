package Cryptographing;

public class Test {

    public static void main(String[] args){

        String poruka = "test poruka \n"+
                "i nova je dosla, \n" +
                "i jos jedna, \n" +
                "pa jos jedna!!!\n";

        SendingPackage ret = CryptoWork.Cryptograhping(poruka);

        System.out.println(ret.message);

        String dekripto = DecryptoWork.Decryptograhping(ret);

        System.out.println(dekripto);

    }

}
