package se.kth.assignment1;

public class Cmv {
    private boolean[] cmv;

    public Cmv(LIC lic) {
        this.cmv = new boolean[15];
        this.cmv = createVector(lic);
    }

    public boolean[] createVector(LIC lic) {
        for (int i = 0; i < cmv.length; i++) {
            switch (i) {
            case 0:
                cmv[i] = lic.cond0();
            case 1:
                cmv[i] = lic.cond1();
            case 2:
                cmv[i] = lic.cond2();
            case 3:
                cmv[i] = lic.cond3();
            case 4: 
                cmv[i] = lic.cond4();
            case 5:
                cmv[i] = lic.cond5();
            case 6: 
                cmv[i] = lic.cond6();
            case 7: 
                cmv[i] = lic.cond7();
            case 8:
                cmv[i] = lic.cond8();
            case 9:
                cmv[i] = lic.cond9();
            case 10:
                cmv[i] = lic.cond10();
            case 11:
                cmv[i] = lic.cond11();
            case 12:
                cmv[i] = lic.cond12();
            case 13:
                cmv[i] = lic.cond13();
            case 14:
                cmv[i] = lic.cond14();
        }
    }
    return cmv;
    }

    public boolean[] getCmv() {
        return cmv;
    }
}
