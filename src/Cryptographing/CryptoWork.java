package Cryptographing;

public class CryptoWork {

    public static SendingPackage Cryptograhping(String message) {

        SendingPackage messageReturn = null;

        switch (AlgorithmChoose.chooseAlgorithm()) {
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

    private static SendingPackage algorithm0(String message) {

        int br_reci = (message.split(" ")).length;

        char niz[] = message.toCharArray();
        int br_do_a = 0;
        for (Character c : niz) {
            if (!"a".equalsIgnoreCase(c.toString()))
                br_do_a++;
            else
                break;
        }

        int pomeraj = br_do_a + br_reci;

        for (int i = 0; i < niz.length / 2; i++) {
            if (i % 2 == 0) {
                char tmp = niz[i];
                niz[i] = niz[niz.length - i - 1];
                niz[niz.length - i - 1] = tmp;
            }
        }

        for (int i = 0; i < niz.length; i++) {
            if (i % 2 == 0) {
                niz[i] += pomeraj;
            } else {
                niz[i] -= pomeraj;
            }
        }

        SendingPackage ret = new SendingPackage();
        ret.message = new String(niz);
        ret.parrametars.add(0);
        ret.parrametars.add(pomeraj);

        return ret;
    }

    private static SendingPackage algorithm1(String message) {

        int br_slova_e = 0, br_slova_c=0;
        char[] niz = message.toCharArray();

        for (Character c : niz) {
            if (!"e".equalsIgnoreCase(c.toString()))
                br_slova_e++;
        }
        for (Character c : niz) {
            if (!"c".equalsIgnoreCase(c.toString()))
                br_slova_e++;
        }

        int pomeraj = (br_slova_e-br_slova_c);

        if(br_slova_c!=0)
            pomeraj=pomeraj*br_slova_c;

        for (int i = 0; i < niz.length / 2; i++) {
            if (i % 3 == 1) {
                char tmp = niz[i];
                niz[i] = niz[niz.length - i - 1];
                niz[niz.length - i - 1] = tmp;
            }
        }

        for (int i = 0; i < niz.length; i++) {
            if (i % 2 == 0) {
                niz[i] -= pomeraj;
            } else {
                niz[i] += pomeraj;
            }
        }

        SendingPackage ret = new SendingPackage();
        ret.message = new String(niz);
        ret.parrametars.add(1);
        ret.parrametars.add(pomeraj);

        return ret;
    }

    private static SendingPackage algorithm2(String message) {
        //TODO
        SendingPackage ret=new SendingPackage();
        ret.message=message;
        ret.parrametars.add(2);
        ret.parrametars.add(0);
        return ret;
    }

    private static SendingPackage algorithm3(String message) {
        //TODO
        SendingPackage ret=new SendingPackage();
        ret.message=message;
        ret.parrametars.add(3);
        ret.parrametars.add(0);
        return ret;
    }

    private static SendingPackage algorithm4(String message) {
        //TODO
        SendingPackage ret=new SendingPackage();
        ret.message=message;
        ret.parrametars.add(4);
        ret.parrametars.add(0);
        return ret;
    }

    private static SendingPackage algorithm5(String message) {
        //TODO
        SendingPackage ret=new SendingPackage();
        ret.message=message;
        ret.parrametars.add(5);
        ret.parrametars.add(0);
        return ret;
    }

}
