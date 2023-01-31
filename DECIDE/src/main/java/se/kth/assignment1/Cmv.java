package se.kth.assignment1;

public class Cmv {
    private boolean[] cmv;

    public Cmv(LIC lic, Parameters parameters, Points points) {
        this.cmv = new boolean[15];
        this.cmv = createVector(lic, parameters, points);
    }

    public boolean[] createVector(LIC lic, Parameters parameters, Points points) {
        for (int i = 0; i < cmv.length; i++) {
            switch (i) {
            case 0:
                cmv[i] = lic.cond0(parameters, points);
            case 1:
                cmv[i] = lic.cond1(points, parameters);
            case 2:
                cmv[i] = lic.cond2(points, parameters);
            case 3:
                cmv[i] = lic.cond3(points, parameters);
            case 4: 
                cmv[i] = lic.cond4(points, parameters);
            case 5:
                cmv[i] = lic.cond5(points, parameters);
            case 6: 
                cmv[i] = lic.cond6(parameters,points);
            case 7: 
                cmv[i] = lic.cond7(parameters, points);
            case 8:
                cmv[i] = lic.cond8(points, parameters);
            case 9:
                cmv[i] = lic.cond9(points, parameters);
            case 10:
                cmv[i] = lic.cond10(points, parameters);
            case 11:
                cmv[i] = lic.cond11(points, parameters);
            case 12:
                cmv[i] = lic.cond12(parameters, points);
            case 13:
                cmv[i] = lic.cond13(parameters, points);
            case 14:
                cmv[i] = lic.cond14(points, parameters);
        }
    }
    return cmv;
    }

    public boolean[] getCmv() {
        return cmv;
    }
}
