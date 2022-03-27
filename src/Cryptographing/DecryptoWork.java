package Cryptographing;

public class DecryptoWork {

    public static String Decryptograhping(SendingPackage message) {

        String messageReturn = null;

        switch (message.parrametars.get(0)) {
            case 0:
                messageReturn = algorithm0(message);
                break;
            case 1:
                messageReturn = algorithm1(message);
                break;
            case 2:
                messageReturn = algorithm2(message);
                break;
            case 3:
                messageReturn = algorithm3(message);
                break;
            case 4:
                messageReturn = algorithm4(message);
                break;
            case 5:
                messageReturn = algorithm5(message);
                break;
        }

        return messageReturn;
    }

    private static String algorithm0(SendingPackage message) {

        int pomeraj = message.parrametars.get(1);
        char[] niz = message.message.toCharArray();

        for(int i=0; i <niz.length;i++){
            if(i%2==0){
                niz[i]-=pomeraj;
            }else{
                niz[i]+=pomeraj;
            }
        }

        for(int i=0; i<niz.length / 2;i++){
            if(i % 2 == 0) {
                char tmp = niz[i];
                niz[i] = niz[niz.length - i - 1];
                niz[niz.length - i - 1] = tmp;
            }
        }

        String ret = new String(niz);

        return ret;
    }

    private static String algorithm1(SendingPackage message) {
        int pomeraj = message.parrametars.get(1);
        char[] niz=message.message.toCharArray();

        for (int i = 0; i < niz.length; i++) {
            if (i % 2 == 0) {
                niz[i] += pomeraj;
            } else {
                niz[i] -= pomeraj;
            }
        }

        for (int i = 0; i < niz.length / 2; i++) {
            if (i % 3 == 1) {
                char tmp = niz[i];
                niz[i] = niz[niz.length - i - 1];
                niz[niz.length - i - 1] = tmp;
            }
        }

        String ret= new String(niz);

        return ret;
    }

    private static String algorithm2(SendingPackage message) {
        return message.message;
        //TODO
    }

    private static String algorithm3(SendingPackage message) {
        //TODO
        return message.message;
    }

    private static String algorithm4(SendingPackage message) {
        //TODO
        return message.message;
    }

    private static String algorithm5(SendingPackage message) {
        //TODO
        return message.message;
    }

}
